package conduz.rodrigues.joaor.co.mz.conduz.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;

/**
 * Created by João Rodrigues on 8/18/2016.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    private List<String> dataset;

    public SimpleAdapter (List<String> dataset){
        this.dataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.simpleTextView.setText(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView simpleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            simpleTextView = (TextView)itemView.findViewById(R.id.tv_simple_text_view);
        }
    }
}
