package com.example.vanessa.childdevelopmentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.vanessa.childdevelopmentapp.classes.Question;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.version;

/**
 * Created by Vanessa on 07/11/2017.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    //db name
    public static String DATABASE_QN = "questionBank.db";
    //db version
    public static final int DATABASE_VERSION = 1;
    //db table name
    public static final String TABLE_QUESTION = "QuestionBank";
    //fields in db
    public static final String KEY_ID = "id";
    public static final String QUESTION = "question";
    public static final String CHOICE1 = "choice1";
    public static final String CHOICE2 = "choice2";
    public static final String ANSWER = "answer";

    //qn table quesry
    public static final String CREATE_TABLE_QUESTION = "CREATE TABLE"
            + TABLE_QUESTION + "(" + KEY_ID
            + "INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION + "TEXT,"
            + CHOICE1 + "TEXT, " + CHOICE2 + "TEXT, " + ANSWER + "TEXT);";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_QN, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        create question table
        sqLiteDatabase.execSQL(CREATE_TABLE_QUESTION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //drop table if exists
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + CREATE_TABLE_QUESTION);
        onCreate(sqLiteDatabase);
    }

    //add qn data in qn table
    public long addInitialQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
//        create content values
        ContentValues values = new ContentValues();
        values.put(QUESTION, question.getQuestion());
        values.put(CHOICE1, question.getChoice(0));
        values.put(CHOICE2, question.getChoice(1));
        values.put(ANSWER, question.getAnswer());
//        insert row in qn table
        long insert = db.insert(TABLE_QUESTION, null, values);
        return insert;
    }

//    extract data from db and save in arraylist of datatype

    public List<Question> getAllQuestionsList() {
        List<Question> questionArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTION;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        //loop through records and add to list
        if (c.moveToFirst()) {
            do {

                Question question = new Question();

                String questText = c.getString(c.getColumnIndex(QUESTION));
                question.setQuestion(questText);

                String choice1Text = c.getString(c.getColumnIndex(CHOICE1));
                question.setChoice(0, choice1Text);

                String choice2Text = c.getString(c.getColumnIndex(CHOICE2));
                question.setChoice(1, choice2Text);

                String answerText = c.getString(c.getColumnIndex(ANSWER));
                question.setQuestion(answerText);

                //add qn to list
                questionArrayList.add(question);
            } while (c.moveToNext());
        }
        return questionArrayList;
    }
}
