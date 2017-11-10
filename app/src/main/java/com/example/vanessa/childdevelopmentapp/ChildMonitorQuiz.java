package com.example.vanessa.childdevelopmentapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class ChildMonitorQuiz extends AppCompatActivity {
    
    Button zeromonths, fivemonths, twelvemonths, twoyears, threehalfyears;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_monitor_quiz);
        
        zeromonths = (Button)findViewById(R.id.zerofourmonths);
        fivemonths = (Button)findViewById(R.id.fivetotwelvemths);
        twelvemonths = (Button)findViewById(R.id.twelvetotwentyfourmths);
        twoyears = (Button)findViewById(R.id.twotothreeandahalfyears);
        threehalfyears = (Button)findViewById(R.id.threehalftofiveyears);
        
        zeromonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zeromonthsdialog();
            }
        });
        
        fivemonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fivemonthsdialog();
            }
        });
        
        twelvemonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twelvemonthsdialog();
            }
        });

        twoyears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoyearsdialog();
            }
        });

        threehalfyears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threehalfyearsyearsdialog();
            }
        });
        
    }

    private void zeromonthsdialog() {
//
        AlertDialog.Builder zerodialog = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.activity_zero,null);
        zerodialog.setView(dialogView);
        zerodialog.setTitle("child monitor");
//        zerodialog.click
//        zerodialog.setPositiveButton("Done", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
        zerodialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(ChildMonitorQuiz.this, MainActivity.class));
            }
        });

        AlertDialog builderdialog = zerodialog.create();
        builderdialog.show();

    }

    private void fivemonthsdialog() {

    }

    private void twelvemonthsdialog() {
    }

    private void twoyearsdialog() {

    }

    private void threehalfyearsyearsdialog() {
    }


}
