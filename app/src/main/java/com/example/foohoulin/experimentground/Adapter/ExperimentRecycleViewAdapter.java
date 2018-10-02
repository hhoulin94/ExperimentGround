package com.example.foohoulin.experimentground.Adapter;
import com.example.foohoulin.experimentground.MapActivity;
import com.example.foohoulin.experimentground.Modal.ExperimentModal;
import com.example.foohoulin.experimentground.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ExperimentRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<ExperimentModal> items ;
    public Context ctx ;

    public ExperimentRecycleViewAdapter(Context ctx , List<ExperimentModal> items){
        this.ctx = ctx ;
        this.items = items ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.experiment_single_item, parent, false);
        return new ExperimentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        final ExperimentViewHolder holder = (ExperimentViewHolder) viewHolder;
        holder.experiment_title.setText(String.valueOf(items.get(position).getItemTitle()));
        holder.experiment_content.setText(String.valueOf(items.get(position).getItemAddress()));
//        Picasso.get().load("https://c.76.my/UserImages/Items/TB220/197/859/197859398.jpg").into(holder.experiment_image);
        holder.main_wrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx , MapActivity.class);
                intent.putExtra("LatLng" , items.get(position).getLatLng());
                ctx.startActivity(intent);
            }
        });
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ExperimentViewHolder extends RecyclerView.ViewHolder implements OnMapReadyCallback {
        TextView experiment_title ;
        TextView experiment_content ;
        ImageView experiment_image ;
        LinearLayout experiment_detail_wrapper ;
        ConstraintLayout main_wrapper ;
        GoogleMap map;
        MapView mapView ;

        public ExperimentViewHolder(View v) {
            super(v);
            main_wrapper = v.findViewById(R.id.main_wrapper) ;
            mapView = v.findViewById(R.id.mapView);
            experiment_detail_wrapper = v.findViewById(R.id.experiment_detail_wrapper) ;
            experiment_title = v.findViewById(R.id.experiment_title) ;
            experiment_content = v.findViewById(R.id.experiment_content);
            experiment_image = v.findViewById(R.id.experiment_image);
            if(mapView != null){
                mapView.onCreate(null);
                mapView.getMapAsync(this);
            }
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            MapsInitializer.initialize(ctx);

            ExperimentModal item = (ExperimentModal) mapView.getTag();

            googleMap.addMarker(new MarkerOptions()
                    .position(item.getLatLng())
                    .title("LinkedIn")
                    .snippet("LinedIn HQ ")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(item.getLatLng(), 15));

            googleMap.getUiSettings().setAllGesturesEnabled(false); //disbale all gesture

            map = googleMap ;

        }


        private void bindView(int pos) {
            ExperimentModal item = items.get(pos) ;
            // Store a reference to the item in the mapView's tag. We use it to get the
            // coordinate of a location, when setting the map location.
            mapView.setTag(item);
        }

    }

}
