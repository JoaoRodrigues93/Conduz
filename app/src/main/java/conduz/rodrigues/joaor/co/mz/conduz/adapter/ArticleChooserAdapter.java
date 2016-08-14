package conduz.rodrigues.joaor.co.mz.conduz.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.model.Seccao;
import conduz.rodrigues.joaor.co.mz.conduz.model.Subtitulo;
import conduz.rodrigues.joaor.co.mz.conduz.model.Titulo;

/**
 * Created by João Rodrigues on 8/9/2016.
 */
public class ArticleChooserAdapter extends RecyclerView.Adapter<ArticleChooserAdapter.ViewHolder> {

    private List mDataset;
    private String type;
    private TextView.OnClickListener onClickListener = new TextView.OnClickListener() {

        @Override
        public void onClick(View view) {
            onTitleClick(view);
        }
    };
    public ArticleChooserAdapter (List dataSet, String type){
        mDataset =  dataSet;
        this.type = type;
    }

    @Override
    public ArticleChooserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_chooser_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ArticleChooserAdapter.ViewHolder holder, int position) {
        if(type == "titulo")
            bindTitulo(holder,position);
        else if(type=="capitulo")
            bindCapitulo(holder,position);
        else if (type=="seccao")
            bindSeccao(holder,position);
    }

    private void onTitleClick (View view){
        view.setBackgroundColor(view.getResources().getColor(R.color.colorPrimary));
        ((TextView)view).setTextColor(Color.WHITE);
    }

    private void bindTitulo(ArticleChooserAdapter.ViewHolder holder,int position) {
        Titulo titulo = (Titulo)mDataset.get(position);

        holder.articleChooseTitile.setText(titulo.getNome());
    }

    private void bindCapitulo(ArticleChooserAdapter.ViewHolder holder,int position){
        Subtitulo subtitulo = (Subtitulo) mDataset.get(position);
        holder.articleChooseTitile.setText(subtitulo.getNome());

    }

    private void bindSeccao (ArticleChooserAdapter.ViewHolder holder,int position){
        Seccao seccao = (Seccao) mDataset.get(position);
        holder.articleChooseTitile.setText(seccao.getNome());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView articleChooseTitile;

        public ViewHolder(View itemView) {
            super(itemView);

            articleChooseTitile = (TextView)itemView.findViewById(R.id.article_chooser_title);
        }
    }
}
