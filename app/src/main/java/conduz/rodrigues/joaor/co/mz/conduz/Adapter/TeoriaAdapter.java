package conduz.rodrigues.joaor.co.mz.conduz.adapter;

/**
 * Created by João Rodrigues on 6/19/2016.
 */

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;

public class TeoriaAdapter extends RecyclerView.Adapter<TeoriaAdapter.ViewHolder> {

    private List<String> mDataset;
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

    public TeoriaAdapter(List<String> myDataset) {
        mDataset = myDataset;
    }

    public TeoriaAdapter(List<String> myDataset,int colors []) {
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
        holder.title.setText(mDataset.get(position));
        RecyclerView recyclerView = holder.temas;
        int [] images = null;
        int [] images1 = new int[3];
        int [] images2 = new int[4];
        int [] images3 = new int[5];
        List<String> newDataset = new ArrayList<String>();
        switch (position){
            case 0:
                newDataset.add("Composição");
                newDataset.add("Função da Condução");
                newDataset.add("O condutor");
                images1[0] = R.drawable.sample_1;
                images1[1] = R.drawable.sample_2;
                images1[2] = R.drawable.sample_3;
                images = images1;
                break;
            case 1:
                newDataset.add("Caminhos");
                newDataset.add("Ruas");
                newDataset.add("Estradas");
                newDataset.add("Auto-estradas");
                images2[0] = R.drawable.sample_4;
                images2[1] = R.drawable.sample_5;
                images2[2] = R.drawable.sample_6;
                images2[3] = R.drawable.sample_10;
                images = images2;
                break;
            case 2:
                newDataset.add("Agentes reguladores de trânsito");
                newDataset.add("sinais luminosos");
                newDataset.add("Gráficos");
                newDataset.add("Dos condutores");
                newDataset.add("tipos de sinais e sua hierarquia");
                images3[0] = R.drawable.sample_7;
                images3[1] = R.drawable.sample_8;
                images3[2] = R.drawable.sample_9;
                images3[3] = R.drawable.sample_11;
                images3[4] = R.drawable.sample_12;
                images = images3;
                break;
        }

        TemaAdapter temaAdapter = new TemaAdapter(newDataset,mColors[position],images);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext(),3);
        recyclerView.setAdapter(temaAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

