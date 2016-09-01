package conduz.rodrigues.joaor.co.mz.conduz.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.model.Artigo;

/**
 * Created by João Rodrigues on 7/6/2016.
 */
public class ArtigoAdapter extends RecyclerView.Adapter<ArtigoAdapter.ViewHolder> {

    List <Artigo> mDataset;

    public ArtigoAdapter (List myDataset){
        mDataset = myDataset;
    }

    public void setmDataset(List<Artigo> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.artigo_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artigo artigo;
        artigo = mDataset.get(position);
        holder.articleNumber.setText("Artigo "+artigo.getNumero());
        holder.articleContent.setText(artigo.getConteudo());
        holder.articleTitle.setText(artigo.getTitulo());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView articleTitle;
        public TextView articleNumber;
        public TextView articleContent;

        public ViewHolder(View itemView) {
            super(itemView);
            articleTitle = (TextView)itemView.findViewById(R.id.tv_title);
            articleNumber = (TextView) itemView.findViewById(R.id.tv_article_number);
            articleContent = (TextView)itemView.findViewById(R.id.tv_article_content);
        }

    }
}

