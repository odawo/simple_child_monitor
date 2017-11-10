package com.example.vanessa.childdevelopmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class FinalDisplay extends AppCompatActivity {

    ArrayList<String> myAnsList=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_display);

        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingbar);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);

        //get text view
        TextView txtAnsweredqns =(TextView)findViewById(R.id.output);
        TextView txtResults=(TextView)findViewById(R.id.results);

//        get score from previous activity
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("score");
        int totalQs = bundle.getInt("totalQs");
        myAnsList = bundle.getStringArrayList("myAnsList");

        //display score
        bar.setRating(score);

        txtAnsweredqns.setText("You have answered "+score+" of "+totalQs+" questions  correctly!");

        float percentage=(score*100)/totalQs;

        if (percentage>=80 && percentage<=100){
            txtResults.setText("Your child is developing extremely well.");
        }else if(percentage>=70 && percentage<=79){
            txtResults.setText("Your child is developing well.");
        }else if(percentage>=60 && percentage<=69){
            txtResults.setText("Your child is developing moderately.");
        }else if(percentage>=50 && percentage<=59){
            txtResults.setText("Your child is developing averagely.");
        }else if(percentage>=33 && percentage<=49){
            txtResults.setText("Your child's development is really slow. Consider medical attention");
        }else{
            txtResults.setText("Your child's development is extremely slow. Report to hospital");
        }

        Button done = (Button)findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
