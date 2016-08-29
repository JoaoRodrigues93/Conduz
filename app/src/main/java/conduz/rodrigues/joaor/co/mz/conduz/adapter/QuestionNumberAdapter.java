package conduz.rodrigues.joaor.co.mz.conduz.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;

/**
 * Created by João Rodrigues on 8/28/2016.
 */
public class QuestionNumberAdapter extends RecyclerView.Adapter<QuestionNumberAdapter.ViewHolder> {
    List<String> dataset;

    public QuestionNumberAdapter (List<String> dataset) {
        this.dataset = dataset;
    }


    @Override
    public QuestionNumberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_number_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QuestionNumberAdapter.ViewHolder holder, int position) {
        holder.questionNumber.setText(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Button questionNumber;

        public ViewHolder(View itemView) {
            super(itemView);

            questionNumber = (Button) itemView.findViewById(R.id.tv_question_number);
        }
    }
}
