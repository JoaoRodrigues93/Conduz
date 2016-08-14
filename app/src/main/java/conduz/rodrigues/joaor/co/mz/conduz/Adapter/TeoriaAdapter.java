package conduz.rodrigues.joaor.co.mz.conduz.adapter;

/**
 * Created by João Rodrigues on 6/19/2016.
 */

import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.model.Capitulo;
import conduz.rodrigues.joaor.co.mz.conduz.model.SampleModel;
import conduz.rodrigues.joaor.co.mz.conduz.model.Tema;

public class TeoriaAdapter extends RecyclerView.Adapter<TeoriaAdapter.ViewHolder> {

    private List<Capitulo> mDataset;
    private int [] mColors;


    public static class ViewHolder extends RecyclerView.ViewHolder  {


        public TextView title;
        public RecyclerView temas;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.tv_chapter_title);
            temas = (RecyclerView)v.findViewById(R.id.rv_themes_view);
        }
    }

    public TeoriaAdapter(List<Capitulo> myDataset) {
        mDataset = myDataset;
    }

    public TeoriaAdapter(List<Capitulo> myDataset,int colors []) {
        mDataset = myDataset;
        mColors = colors;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.capitulo_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Capitulo capitulo;
        capitulo = mDataset.get(position);

        holder.title.setText(capitulo.getNome());
        RecyclerView recyclerView = holder.temas;

        List<Tema> newDataset;
        SampleModel sampleModel = new SampleModel();
        newDataset = sampleModel.SampleTema();


        TemaAdapter temaAdapter = new TemaAdapter(newDataset,mColors[position]);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext(),3);
        recyclerView.setAdapter(temaAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

