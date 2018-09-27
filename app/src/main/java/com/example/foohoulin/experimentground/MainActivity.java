package com.example.foohoulin.experimentground;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.foohoulin.experimentground.Adapter.ExperimentRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView experimentRecycleView ;
    private ExperimentRecycleViewAdapter experimentRecycleViewAdapter ;
    private List<String> list1 ;
    private Button mapButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        experimentRecycleView = findViewById(R.id.experiment_recycler_view);

        experimentRecycleView.setHasFixedSize(true);
        experimentRecycleView.setLayoutManager(new GridLayoutManager(this , 2));

        list1 = new ArrayList<String>();

        for(int i = 0 ; i < 50 ; i++){
            list1.add(String.valueOf(i));
        }

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
