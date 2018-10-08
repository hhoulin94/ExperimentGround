package com.example.foohoulin.experimentground;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    SupportMapFragment mapFragment;
    /*
    * 1 - World
    * 5 - Landmass/continent
    * 10 - City
    * 15 - Street
    * 20 - Buildings
    * */
    private static final int zoomCamera = 15;
    private LatLng latLng ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_map);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        if(intent.hasExtra("LatLng")){
            latLng = intent.getExtras().getParcelable("LatLng");
        }else{
            latLng = new LatLng(37.4233438 , -122.0728817);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("LinkedIn")
                .snippet("LinedIn HQ ")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomCamera));

        googleMap.getUiSettings().setAllGesturesEnabled(false); //disbale all gesture

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home :
                this.onBackPressed();
                return true ;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
