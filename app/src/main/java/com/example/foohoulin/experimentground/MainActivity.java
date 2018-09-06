package com.example.foohoulin.experimentground;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.foohoulin.experimentground.Adapter.ExperimentRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView experimentRecycleView ;
    ExperimentRecycleViewAdapter experimentRecycleViewAdapter ;
    List<String> list1 ;

    AppBarLayout appbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        experimentRecycleView = findViewById(R.id.experiment_recycler_view);

        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setTitle("Title");

        experimentRecycleView.setHasFixedSize(true);
        experimentRecycleView.setLayoutManager(new GridLayoutManager(this , 2));

        list1 = new ArrayList<String>();

        for(int i = 0 ; i < 50 ; i++){
            list1.add(String.valueOf(i));
        }

        experimentRecycleViewAdapter = new ExperimentRecycleViewAdapter(getApplicationContext() , list1 );
        experimentRecycleView.setAdapter(experimentRecycleViewAdapter);

        appbar = findViewById(R.id.appbar);

    }
}
