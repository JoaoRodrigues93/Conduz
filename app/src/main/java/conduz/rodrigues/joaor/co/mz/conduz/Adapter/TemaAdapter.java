package conduz.rodrigues.joaor.co.mz.conduz.adapter;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import conduz.rodrigues.joaor.co.mz.conduz.activity.LeituraActivity;
import conduz.rodrigues.joaor.co.mz.conduz.R;
import conduz.rodrigues.joaor.co.mz.conduz.model.Tema;

/**
 * Created by João Rodrigues on 6/19/2016.
 */
public class TemaAdapter extends RecyclerView.Adapter<TemaAdapter.ViewHolder> {

    private List<Tema> mDataset;
    private int mColor;


    public static class ViewHolder extends RecyclerView.ViewHolder  {


        public TextView title;
        public ImageView temaIcon;
        public LinearLayout temaIconLayout;
        public LinearLayout temaLayout;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.tv_tema);
            temaIcon = (ImageView) v.findViewById(R.id.iv_tema_icon);
            temaIconLayout = (LinearLayout) v.findViewById(R.id.ll_tema_icon);
            temaLayout = (LinearLayout) v.findViewById(R.id.ll_tema);
        }
    }

    public TemaAdapter(List<Tema> myDataset) {
        mDataset = myDataset;
    }

    public TemaAdapter(List<Tema> myDataset,int color) {
        mDataset = myDataset;
        mColor = color;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tema_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Tema tema = mDataset.get(position);
        holder.title.setText(tema.getNome());
        changeBackground(holder.temaIconLayout);
        holder.temaIcon.setImageResource(tema.getIconeResource());
        holder.temaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),LeituraActivity.class);
                intent.putExtra(LeituraActivity.TITLE,tema.getNome());
                intent.putExtra(LeituraActivity.COLOR,mColor);
                intent.putExtra(LeituraActivity.SUBTITLE,"Capítulo");
                intent.putExtra(LeituraActivity.IMAGE_RESOURCE,tema.getIconeResource());
                intent.putExtra(LeituraActivity.CONTENT,tema.getConteudo());
                view.getContext().startActivity(intent);
            }
        });
    }


    private void changeBackground (View view){
        Drawable background = view.getBackground();

        if(background instanceof ShapeDrawable){
            ((ShapeDrawable)background).getPaint().setColor(mColor);
        }
        else if (background instanceof GradientDrawable){
            ((GradientDrawable)background).setColor(mColor);
        }
        else if (background instanceof ColorDrawable) {
            ((ColorDrawable)background).setColor(mColor);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

