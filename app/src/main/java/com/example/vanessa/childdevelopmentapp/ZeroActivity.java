package com.example.vanessa.childdevelopmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vanessa.childdevelopmentapp.classes.Question;
import com.example.vanessa.childdevelopmentapp.classes.QuestionBank;

public class ZeroActivity extends AppCompatActivity {

    private QuestionBank mQnLib = new QuestionBank();

    Button btnchoice1, btnchoice2;
    TextView questionview, scoreview;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

        btnchoice1 = (Button)findViewById(R.id.btnchoice1);
        btnchoice2 = (Button)findViewById(R.id.btnchoice2);
        questionview = (TextView) findViewById(R.id.question);
        scoreview = (TextView) findViewById(R.id.score);

        mQnLib.initQuestions(getApplicationContext());
        updateQuestion();
//        show current score. The score helps gauge the child's devt
        updateScore(mScore);
    }

    private void updateQuestion() {

//        check if not outside array bounds

        if (mQuestionNumber<mQnLib.getLength()) {
            //set text for new qn
            questionview.setText(mQnLib.getQuestion(mQuestionNumber));
            btnchoice1.setText(mQnLib.getChoice(mQuestionNumber, 1));
            btnchoice2.setText(mQnLib.getChoice(mQuestionNumber, 2));
            mAnswer = mQnLib.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;

        } else {
            Toast.makeText(ZeroActivity.this, "end of questionnaire. wait as results load", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ZeroActivity.this, FinalDisplay.class);
            //pass score data to FinalDisplay activity
            intent.putExtra("score", mScore);
            startActivity(intent);
        }

    }

    //show current total
    private void updateScore(int point) {
        scoreview.setText("" +mScore+"/" +mQnLib.getLength());
    }

    public void onClick(View view) {
        //all logic for all answers button in one method
        Button answer = (Button) view;
        
        if (answer.getText().equals(mAnswer)) {
            //score increase once answer is correct
            mScore = mScore + 1;
        }

//      show current score total
        updateScore(mScore);

//        moves user to next screen once qn is answered
        updateQuestion();
    }
}
