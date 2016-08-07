package conduz.rodrigues.joaor.co.mz.conduz.adapter;

/**
 * Created by João Rodrigues on 7/7/2016.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;

/**
 * Created by João Rodrigues on 7/7/2016.
 */
public class ExameAdapter extends RecyclerView.Adapter<ExameAdapter.ViewHolder> {

    List<String> mDataset;

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
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView exameNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            exameNumber = (TextView) itemView.findViewById(R.id.tv_exam_number);
        }

    }
}

