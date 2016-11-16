package ph.edu.dlsu.mobidev.communipic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cristopher on 11/14/2016.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ChoresViewHolder> {

    private ArrayList<Picture> listChores; //local copy
    public PictureAdapter(ArrayList<Picture> listChores){

        this.listChores = listChores;
    }

    @Override
    public ChoresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chores, parent,false);

        return new ChoresViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChoresViewHolder holder, int position) {
        Picture currentChores = listChores.get(position);
        holder.tvChores.setText(currentChores.getName());
        holder.ivChores.setImageResource(currentChores.getPictureKey());
    }

    @Override
    public int getItemCount() {
        return listChores.size();
    }

    public class ChoresViewHolder extends RecyclerView.ViewHolder {
        TextView tvChores;
        ImageView ivChores;

        public ChoresViewHolder(View itemView) {
            //itemView is list_item_food inflated, ready to use as an object
            super(itemView);
            // intialize views
            tvChores = (TextView) itemView.findViewById(R.id.tv_chores);
            ivChores = (ImageView) itemView.findViewById(R.id.iv_chores);
            itemView.setClickable(true);
        }
    }

}

