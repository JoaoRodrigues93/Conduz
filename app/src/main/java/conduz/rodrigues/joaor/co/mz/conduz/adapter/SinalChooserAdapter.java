package conduz.rodrigues.joaor.co.mz.conduz.adapter;

import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.activity.SinalChooser;
import conduz.rodrigues.joaor.co.mz.conduz.model.Capitulo;
import conduz.rodrigues.joaor.co.mz.conduz.model.CapituloSinal;
import conduz.rodrigues.joaor.co.mz.conduz.model.Quadro;
import conduz.rodrigues.joaor.co.mz.conduz.model.Titulo;

/**
 * Created by João Rodrigues on 8/23/2016.
 */
public class SinalChooserAdapter extends RecyclerView.Adapter<SinalChooserAdapter.ViewHolder> {
    private List dataset;
    private String type;
    private TextView lastSelected;
    private ViewPager mViewPager;
    private int currentPosition;

    public SinalChooserAdapter(List dataset, String type) {
        this.dataset = dataset;
        this.type = type;
    }

    public void setmViewPager(ViewPager mViewPager) {
        this.mViewPager = mViewPager;
    }

    @Override
    public SinalChooserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sinal_chooser_list_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(SinalChooserAdapter.ViewHolder holder, int position) {
        if(type=="capitulo")
            onBindCapitulo (holder,position);
        else if (type=="seccao")
            onBindSeccao (holder,position);

    }

    private void onBindSeccao(ViewHolder holder, int position) {
        Quadro seccao = (Quadro) dataset.get(position);
        if(seccao.getId()== SinalChooser.seccaoId){
            holder.sinalChooserTitle.setTextColor(holder.sinalChooserTitle.getResources().getColor(R.color.colorPrimary));
            holder.sinalChooserTitle.setTypeface(null, Typeface.BOLD);
        }
        holder.sinalChooserTitle.setText(seccao.getNome());
    }

    private void onBindCapitulo(ViewHolder holder, int position) {
        CapituloSinal capitulo = (CapituloSinal) dataset.get(position);
        if(capitulo.getId() == SinalChooser.capituloId){
            holder.sinalChooserTitle.setTextColor(holder.sinalChooserTitle.getResources().getColor(R.color.colorPrimary));
            holder.sinalChooserTitle.setTypeface(null, Typeface.BOLD);
        }
        holder.sinalChooserTitle.setText(capitulo.getNome());
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView sinalChooserTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            sinalChooserTitle = (TextView) itemView.findViewById(R.id.sinal_chooser_title);
        }
    }
}
