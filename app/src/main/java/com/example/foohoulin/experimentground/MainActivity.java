package com.example.foohoulin.experimentground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.foohoulin.experimentground.Adapter.ExperimentRecycleViewAdapter;
import com.example.foohoulin.experimentground.Modal.ExperimentModal;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView experimentRecycleView ;
    private ExperimentRecycleViewAdapter experimentRecycleViewAdapter ;
    private List<ExperimentModal> list1 ;
    private Button mapButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        experimentRecycleView = findViewById(R.id.experiment_recycler_view);

        experimentRecycleView.setHasFixedSize(true);
        experimentRecycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        list1 = new ArrayList<ExperimentModal>(){
            {
                add(new ExperimentModal("1U", "123 , Jln 234 , 345556 KL", new LatLng(3.0714, 101.6052)));
                add(new ExperimentModal("Mid Valley", "123 , Jln 234 , 345556 KL", new LatLng(3.1506, 101.6150)));
                add(new ExperimentModal("Sunway Pryamid", "123 , Jln 234 , 345556 KL",new LatLng(3.1179, 101.6778)));
            }
        };

        experimentRecycleViewAdapter = new ExperimentRecycleViewAdapter(getApplicationContext() , list1 );
        experimentRecycleView.setAdapter(experimentRecycleViewAdapter);

        mapButton = findViewById(R.id.map_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , MapActivity.class);
                startActivity(intent);
            }
        });
    }
}
