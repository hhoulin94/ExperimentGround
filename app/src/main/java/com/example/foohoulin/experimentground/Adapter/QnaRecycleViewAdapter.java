package com.example.foohoulin.experimentground.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foohoulin.experimentground.MapActivity;
import com.example.foohoulin.experimentground.Modal.ExperimentModal;
import com.example.foohoulin.experimentground.Modal.QnAModal;
import com.example.foohoulin.experimentground.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class QnaRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<QnAModal> items ;
    public Context ctx ;

    public QnaRecycleViewAdapter(Context ctx , List<QnAModal> items){
        this.ctx = ctx ;
        this.items = items ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.qna_single_item, parent, false);
        return new ExperimentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        final ExperimentViewHolder holder = (ExperimentViewHolder) viewHolder;
        RoundedBitmapDrawable roundDrawable = RoundedBitmapDrawableFactory.create(ctx.getResources() , items.get(position).getAskerProfilePicture());
        roundDrawable.setCircular(true);
        holder.askerProfilePicture.setImageDrawable(roundDrawable);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ExperimentViewHolder extends RecyclerView.ViewHolder {
        ImageView askerProfilePicture ;

        public ExperimentViewHolder(View v) {
            super(v);
            askerProfilePicture = v.findViewById(R.id.askerProfilePicture);

        }

    }

}
