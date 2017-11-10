package com.example.vanessa.childdevelopmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalDisplay extends AppCompatActivity {

    TextView questionsanswered; //score
    TextView output; //highscore ignored

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_display);

        questionsanswered = (TextView)findViewById(R.id.qnsanswered);
        output = (TextView)findViewById(R.id.output);

//        receive data from zeroactivity activity
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        questionsanswered.setText("Questions answered: " + score);
    }
}
