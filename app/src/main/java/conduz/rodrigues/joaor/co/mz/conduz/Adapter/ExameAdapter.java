package conduz.rodrigues.joaor.co.mz.conduz.adapter;

/**
 * Created by João Rodrigues on 7/7/2016.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.activity.ExercicioActivity;

/**
 * Created by João Rodrigues on 7/7/2016.
 */
public class ExameAdapter extends RecyclerView.Adapter<ExameAdapter.ViewHolder> {

    List<String> mDataset;
    View.OnClickListener exameOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openExame(view);
        }
    };

    public ExameAdapter (List<String> myDataset){
        mDataset = myDataset;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exame_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.exameNumber.setText(mDataset.get(position));
        holder.exameNumber.setOnClickListener(exameOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    private void openExame (View view){
        Intent intent = new Intent(view.getContext(), ExercicioActivity.class);
        view.getContext().startActivity(intent);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView exameNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            exameNumber = (TextView) itemView.findViewById(R.id.tv_exam_number);
        }

    }
}

