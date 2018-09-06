package com.example.foohoulin.experimentground.Adapter;
import com.example.foohoulin.experimentground.R;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ExperimentRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> item ;
    private Context ctx ;

    public ExperimentRecycleViewAdapter(Context ctx , List<String> item){
        this.ctx = ctx ;
        this.item = item ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.experiment_single_item, parent, false);
        return new ExperimentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        ExperimentViewHolder holder = (ExperimentViewHolder) viewHolder;
        holder.experiment_title.setText(String.valueOf(item.get(position)));
        holder.experiment_content.setText(String.valueOf(item.get(position)));
        Picasso.get().load("https://c.76.my/UserImages/Items/TB220/197/859/197859398.jpg").into(holder.experiment_image);
    }

    public static class ExperimentViewHolder extends RecyclerView.ViewHolder {
        TextView experiment_title ;
        TextView experiment_content ;
        ImageView experiment_image ;

        public ExperimentViewHolder(View v) {
            super(v);
            experiment_title = v.findViewById(R.id.experiment_title) ;
            experiment_content = v.findViewById(R.id.experiment_content);
            experiment_image = v.findViewById(R.id.experiment_image);
        }
    }


    @Override
    public int getItemCount() {
        return item.size();
    }
}
