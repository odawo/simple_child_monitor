package com.example.vanessa.childdevelopmentapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.vanessa.childdevelopmentapp.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vanessa on 07/11/2017.
 */

//Database Adapter class

public class MyDatabaseHelper extends SQLiteOpenHelper {

    //db name
    private static String DATABASE_NAME = "questionBank.db";
    //db version
    private static final int DATABASE_VERSION = 1;
    //db table name
    private static final String TABLE_QUESTION = "question";
    //fields in db
    private static final String KEY_ID = "id";
    private static final String QUESTION = "question";
    private static final String CHOICE1 = "choice1";
    private static final String CHOICE2 = "choice2";
    private static final String ANSWER = "answer";

    private SQLiteDatabase myDatabase;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        myDatabase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + QUESTION
                + " TEXT, " + ANSWER+ " TEXT, "+ CHOICE1 +" TEXT, "
                +CHOICE2 + " TEXT, )";
//        create question table
        db.execSQL(sql);

        addzeroQuestions();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        drop table if exists
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_QUESTION);
//        creates table again
        onCreate(db);
    }

    public int rowCount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

    public List<Question> getAllQuestionsList() {

        List<Question> questionArrayList = new ArrayList<>();
//        select all ALL(*) query
        String selectQuery = "SELECT * FROM " + TABLE_QUESTION;
        myDatabase = this.getReadableDatabase();

        Cursor cursor = myDatabase.rawQuery(selectQuery, null);

        //loop through records and add to list
        if (cursor.moveToFirst()) {
            do {

                Question question = new Question();

                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                question.setAnswer(cursor.getString(2));
                question.setChoiceyes(cursor.getString(3));
                question.setChoiceno(cursor.getString(4));

                //add qn to list
                questionArrayList.add(question);
            } while (cursor.moveToNext());
        }
        //return quets list
        return questionArrayList;
    }

    private void addzeroQuestions() {

        Question q1=new Question("can a child do a?","yes", "no", "yes");
        this.addInitialQuestion(q1);

        Question q2=new Question("can a child do b?","yes", "no", "yes");
        this.addInitialQuestion(q1);

        Question q3=new Question("can a child do c?","yes", "no", "yes");
        this.addInitialQuestion(q1);

        Question q4=new Question("can a child do d?","yes", "no", "yes");
        this.addInitialQuestion(q1);

        Question q5=new Question("can a child do e?","yes", "no", "yes");
        this.addInitialQuestion(q1);

    }

    //add new qn
    public void addInitialQuestion(Question question) {

//        create content values
        ContentValues values = new ContentValues();
        values.put(QUESTION, question.getQuestion());
        values.put(CHOICE1, question.getChoiceno());
        values.put(CHOICE2, question.getChoiceyes());
        values.put(ANSWER, question.getAnswer());

//        insert row in qn table
        myDatabase.insert(TABLE_QUESTION, null, values);
    }

}
