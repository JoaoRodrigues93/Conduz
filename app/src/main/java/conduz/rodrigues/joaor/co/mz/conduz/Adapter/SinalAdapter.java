package conduz.rodrigues.joaor.co.mz.conduz.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.activity.SinalDetailActivity;
import conduz.rodrigues.joaor.co.mz.conduz.model.Sinal;

/**
 * Created by João Rodrigues on 7/7/2016.
 */
public class SinalAdapter extends RecyclerView.Adapter<SinalAdapter.ViewHolder> {

    List<Sinal> dataset;

    public SinalAdapter (List<Sinal> dataset){
        this.dataset = dataset;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sinal_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Sinal sinal = dataset.get(position);
        holder.sinalCode.setText(sinal.getCodigo());
        holder.sinalImage.setImageResource(sinal.getIconeResource());
        holder.sinalTitle.setText(sinal.getNome());

        holder.sinalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),SinalDetailActivity.class);
                intent.putExtra(SinalDetailActivity.ID_SINAL_ESCOLHIDO,sinal.getId());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView sinalImage;
        public TextView sinalTitle;
        public TextView sinalCode;
        public LinearLayout sinalLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            sinalImage = (ImageView)itemView.findViewById(R.id.iv_sinal_image);
            sinalTitle = (TextView) itemView.findViewById(R.id.tv_sinal_title);
            sinalCode = (TextView)itemView.findViewById(R.id.tv_sinal_code);
            sinalLayout = (LinearLayout) itemView.findViewById(R.id.ll_sinal);
        }

    }
}
