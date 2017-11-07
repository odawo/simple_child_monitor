package com.example.vanessa.childdevelopmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button toquiz, toinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toquiz = (Button)findViewById(R.id.toquiz);
        toinfo = (Button)findViewById(R.id.toinfo);

        toquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ChildMonitorQuiz.class));
            }
        });

        toinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, ChildMonitoInformation.class));
            }
        });

    }
}
