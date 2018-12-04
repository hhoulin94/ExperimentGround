package com.example.foohoulin.experimentground;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.foohoulin.experimentground.Adapter.ExperimentRecycleViewAdapter;
import com.example.foohoulin.experimentground.Adapter.QnaRecycleViewAdapter;
import com.example.foohoulin.experimentground.Modal.ExperimentModal;
import com.example.foohoulin.experimentground.Modal.QnAModal;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView experimentRecycleView ;
    private RecyclerView qnaRecycleView ;
    private ExperimentRecycleViewAdapter experimentRecycleViewAdapter ;
    private QnaRecycleViewAdapter qnaRecycleViewAdapter ;
    private List<ExperimentModal> list1 ;
    private List<QnAModal> qnAModalList ;
    private Button mapButton ;
    private Button mapButton1 ;
    private TextView text_view ;
    private TextView text_view2 ;
    private ProgressBar progress ;

    private TransitionDrawable transitiondrawable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region testing with google map
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
        //endregion

        //region qna attempt
        qnaRecycleView = findViewById(R.id.qna_recycler_view);
        qnaRecycleView.setHasFixedSize(true);
        qnaRecycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        qnAModalList = new ArrayList<QnAModal>(){
            {
            add (new QnAModal("Ali" , "I Kacak tak ?" , "https://c.76.my/UserImages/Items/TB220/197/859/197859398.jpg" , "Chicken" , "Kok Kok KEHHHHH" , "https://c.76.my/UserImages/Items/TB220/197/859/197859398.jpg"));
            add (new QnAModal("Ah Kao" , "Wo Shuai Ma ?" , "https://c.76.my/UserImages/Items/TB220/197/859/197859398.jpg" , "Duck" , "Quack Quack" , "https://c.76.my/UserImages/Items/TB220/197/859/197859398.jpg"));
            add (new QnAModal("Mutu" , "I handsome or not ?" , "https://c.76.my/UserImages/Items/TB220/197/859/197859398.jpg" , "Duck" , "Quack Quack" , "https://c.76.my/UserImages/Items/TB220/197/859/197859398.jpg"));
            }
        };

        qnaRecycleViewAdapter = new QnaRecycleViewAdapter(getApplicationContext() , qnAModalList);
        qnaRecycleView.setAdapter(qnaRecycleViewAdapter);
        //endregion

        RatingBar myRatingBar = findViewById(R.id.ratingBar);
        float current = 2.6f;

        ObjectAnimator anim = ObjectAnimator.ofFloat(myRatingBar, "rating", 0, current);
        anim.setDuration(1000);
        anim.start();

        mapButton = findViewById(R.id.map_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , MapActivity.class);
                overridePendingTransition(R.anim.abc_popup_enter , R.anim.abc_popup_exit);
                startActivity(intent);
            }
        });

        mapButton1 = findViewById(R.id.map_button1);
        mapButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapButton.setVisibility(mapButton.getVisibility() == View.GONE ? View.VISIBLE : View.GONE );
            }
        });

        //region Animator Set
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(mapButton1, "alpha",  1f, 0);
        fadeOut.setDuration(2000);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(mapButton1, "alpha", 0, 1f);
        fadeIn.setDuration(2000);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mAnimationSet.start();
            }
        });
        mAnimationSet.start();

        text_view = findViewById(R.id.text_view);
        float startScale = 1 ;
        float targetScale = 2 ;
        ObjectAnimator scaleOutX = ObjectAnimator.ofFloat(text_view , "scaleX" , startScale , targetScale);
        ObjectAnimator scaleOutY = ObjectAnimator.ofFloat(text_view , "scaleY" , startScale , targetScale);
        scaleOutX.setDuration(1000);
        scaleOutY.setDuration(1000);
        ObjectAnimator scaleInX = ObjectAnimator.ofFloat(text_view, "scaleX", targetScale, startScale );
        ObjectAnimator scaleInY = ObjectAnimator.ofFloat(text_view, "scaleY", targetScale, startScale );
        scaleInX.setDuration(1000);
        scaleInY.setDuration(1000);

        final AnimatorSet mScaleAnimator = new AnimatorSet();

        mScaleAnimator.play(scaleInX).with(scaleInY).after(scaleOutX).with(scaleOutY);

        mScaleAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mScaleAnimator.start();
            }
        });
        mScaleAnimator.start();

        text_view2 = findViewById(R.id.text_view2);

        ColorDrawable[] backgroundColor = {
                new ColorDrawable(Color.parseColor("#757575")),
                new ColorDrawable(Color.parseColor("#FFFFFF"))
        };

        transitiondrawable = new TransitionDrawable(backgroundColor) ;

        text_view2.setBackground(transitiondrawable);

//        mapButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                transitiondrawable.startTransition(1000);
//                text_view2.setText("DONE");
//            }
//        });
        //endregion

        progress = findViewById(R.id.progress);
    }


}
