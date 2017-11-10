package com.example.vanessa.childdevelopmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.vanessa.childdevelopmentapp.model.Question;
import com.example.vanessa.childdevelopmentapp.db.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ZeroActivity extends AppCompatActivity {

    private List<Question> questionsList;
    private Question currentQuestion;

    private TextView txtQuestion,txtNoOfQns;
    private RadioButton btnchoice1, btnchoice2;
    private ImageButton btnNext;

    private int obtainedScore=0;
    private int questionId=0;

    private int answeredQsNo=0;

    ArrayList<String> myAnsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);

//        initialize view
        init();

//        initialize database
        final MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        questionsList = myDatabaseHelper.getAllQuestionsList();
        currentQuestion = questionsList.get(questionId);

//        set Questions
        setQuestionsView();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup rgroup = (RadioGroup)findViewById(R.id.radiogroup);
                RadioButton answer = (RadioButton)findViewById(rgroup.getCheckedRadioButtonId());

                Log.e("Answer ID", "Selected Position Value - " +rgroup.getCheckedRadioButtonId());

                if(answer!=null){
                    Log.e("Answer", currentQuestion.getAnswer() + " -- " + answer.getText());
                    //Add answer to the list
                    myAnsList.add(""+ answer.getText());

                    if(currentQuestion.getAnswer().equals(answer.getText())){
                        obtainedScore++;
                        Log.e("comments", "Correct Answer");
                        Log.d("score", "Obtained score " + obtainedScore);
                    }else{
                        Log.e("comments", "Wrong Answer");
                    }
                    if(questionId<myDatabaseHelper.rowCount()){
                        currentQuestion=questionsList.get(questionId);
                        setQuestionsView();
                    }else{
                        Intent intent = new Intent(ZeroActivity.this, FinalDisplay.class);

                        Bundle b = new Bundle();
                        b.putInt("score", obtainedScore);
                        b.putInt("totalQs", questionsList.size());
                        b.putStringArrayList("myAnsList", myAnsList);
                        intent.putExtras(b);
                        startActivity(intent);
                        finish();

                    }

                } else {
                    Log.e("comments", "No Answer");
                }

//                clear checked item
                rgroup.clearCheck();
            }
        });
    }


    private void init() {

        btnchoice1 = (RadioButton) findViewById(R.id.btnchoice1);
        btnchoice2 = (RadioButton) findViewById(R.id.btnchoice2);
        txtQuestion = (TextView) findViewById(R.id.question);
        txtNoOfQns = (TextView) findViewById(R.id.questionno);

        btnNext = (ImageButton) findViewById(R.id.btnnext);

        myAnsList = new ArrayList<String>();
    }


    private void setQuestionsView() {

        btnchoice1.setChecked(false);
        btnchoice2.setChecked(false);

        answeredQsNo = questionId+1;
        txtNoOfQns.setText("Questions "+answeredQsNo+" of "+questionsList.size());
        txtQuestion.setText(currentQuestion.getQuestion());
        btnchoice1.setText(currentQuestion.getChoiceyes());
        btnchoice2.setText(currentQuestion.getChoiceno());

        questionId++;
    }

}
