package com.example.vanessa.childdevelopmentapp.classes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.vanessa.childdevelopmentapp.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vanessa on 07/11/2017.
 */

public class QuestionBank {
    //zero, five, twelve, two, three
    List<Question> listzero = new ArrayList<>();
//    List<Question> listfive = new ArrayList<>();
    MyDatabaseHelper myDatabaseHelper;

    //no of qns in list
    public int getLength() {
        return listzero.size();
    }

    //return qn from list based on index
    public String getQuestion(int a) {
        return listzero.get(a).getQuestion();
    }

    //return single multiple choice for qn based on list index
    public String getChoice(int index, int num) {
        return listzero.get(index).getChoice(num-1);
    }

    //return correct answer
    //to be commented out after
    public String getCorrectAnswer(int a) {
        return listzero.get(a).getAnswer();
    }

    public void initQuestions(Context context) {
        myDatabaseHelper = new MyDatabaseHelper(context);
//        get all questions, choices and answers from db
        listzero = myDatabaseHelper.getAllQuestionsList();

        //populate db with default qns
        if (listzero.isEmpty()) {
            myDatabaseHelper.addInitialQuestion(new Question("1. can child do a?",
                    new String[]{"yes","no"},"yes"));
            myDatabaseHelper.addInitialQuestion(new Question("2. can child do b?",
                    new String[]{"yes","no"},"yes"));
            myDatabaseHelper.addInitialQuestion(new Question("3. can child do c?",
                    new String[]{"yes","no"},"yes"));
            myDatabaseHelper.addInitialQuestion(new Question("4. can child do d?",
                    new String[]{"yes","no"},"yes"));
            myDatabaseHelper.addInitialQuestion(new Question("5. can child do e?",
                    new String[]{"yes","no"},"yes"));

            listzero = myDatabaseHelper.getAllQuestionsList();
        }
    }

}
