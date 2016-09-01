package conduz.rodrigues.joaor.co.mz.conduz.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.activity.ArticleChooser;
import conduz.rodrigues.joaor.co.mz.conduz.activity.HomeActivity;
import conduz.rodrigues.joaor.co.mz.conduz.fragment.CodigoFragment;
import conduz.rodrigues.joaor.co.mz.conduz.model.Seccao;
import conduz.rodrigues.joaor.co.mz.conduz.model.Subtitulo;
import conduz.rodrigues.joaor.co.mz.conduz.model.Titulo;

/**
 * Created by João Rodrigues on 8/9/2016.
 */
public class ArticleChooserAdapter extends RecyclerView.Adapter<ArticleChooserAdapter.ViewHolder> {

    private List mDataset;
    private String type;
    private TextView lastSelected;
    private ViewPager mViewPager;
    private int currentPosition;
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

    public void setmDataset(List mDataset) {
        this.mDataset = mDataset;
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
        if(lastSelected !=null) {
            lastSelected.setTextColor(view.getResources().getColor(R.color.body));
            lastSelected.setTypeface(null, Typeface.NORMAL);
        }
        ((TextView)view).setTextColor(view.getResources().getColor(R.color.colorPrimary));
        ((TextView)view).setTypeface(null, Typeface.BOLD);
        lastSelected = (TextView) view;
        if(type=="titulo") {
            mViewPager.setCurrentItem(1);
        }
        else if(type =="capitulo") {
            mViewPager.setCurrentItem(2);
        }
        else if (type=="seccao")   {
            Intent intent = new Intent(view.getContext(),HomeActivity.class);
            intent.putExtra(HomeActivity.CHANGE_TAB,true);
            intent.putExtra(HomeActivity.PREFERED_GROUP,"codigo");
            intent.putExtra(CodigoFragment.TITULO,ArticleChooser.tituloId);
            intent.putExtra(CodigoFragment.SUBTITULO_ID,ArticleChooser.subtituloId);
            intent.putExtra(CodigoFragment.SECCAO_ID,ArticleChooser.seccaoId);
            view.getContext().startActivity(intent);
        }
    }

    private void bindTitulo(ArticleChooserAdapter.ViewHolder holder,int position) {
        Titulo titulo = (Titulo)mDataset.get(position);

        holder.articleChooseTitile.setText(titulo.getNome());
        holder.articleChooseTitile.setOnClickListener(onClickListener);
        if(titulo.getId() == ArticleChooser.tituloId)
            chooseTitle(holder.articleChooseTitile);
    }

    private void chooseTitle (View view){
        if(lastSelected !=null) {
            lastSelected.setTextColor(view.getResources().getColor(R.color.body));
            lastSelected.setTypeface(null, Typeface.NORMAL);
        }
        ((TextView)view).setTextColor(view.getResources().getColor(R.color.colorPrimary));
        ((TextView)view).setTypeface(null, Typeface.BOLD);
        lastSelected = (TextView) view;
    }



    private void bindCapitulo(ArticleChooserAdapter.ViewHolder holder,int position){
        Subtitulo subtitulo = (Subtitulo) mDataset.get(position);
        holder.articleChooseTitile.setText(subtitulo.getNome());
        holder.articleChooseTitile.setOnClickListener(onClickListener);
        if(subtitulo.getId() == ArticleChooser.subtituloId)
            chooseTitle(holder.articleChooseTitile);
    }

    private void bindSeccao (ArticleChooserAdapter.ViewHolder holder,int position){
        Seccao seccao = (Seccao) mDataset.get(position);
        holder.articleChooseTitile.setText(seccao.getNome());
        holder.articleChooseTitile.setOnClickListener(onClickListener);
        if(seccao.getId() == ArticleChooser.seccaoId)
            chooseTitle(holder.articleChooseTitile);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setMainViewPager(ViewPager mainViewPager) {
        this.mViewPager = mainViewPager;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView articleChooseTitile;

        public ViewHolder(View itemView) {
            super(itemView);

            articleChooseTitile = (TextView)itemView.findViewById(R.id.article_chooser_title);
        }
    }
}
