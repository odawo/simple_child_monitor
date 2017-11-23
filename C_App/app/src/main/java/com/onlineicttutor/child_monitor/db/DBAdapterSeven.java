package com.onlineicttutor.child_monitor.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.onlineicttutor.child_monitor.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanessa on 5/13/16.
 */
public class DBAdapterSeven extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "childmonitorquizseven";

    // Table name
    private static final String TABLE_QUESTIONSeven = "questionseven";

    // Table Columns names
    private static final String KEY_IDseven = "id";
    private static final String KEY_QUESIONseven = "question";
    private static final String KEY_ANSWERseven = "answer"; //correct option
    private static final String KEY_OPTAseven= "opta"; //option a
    private static final String KEY_OPTBseven= "optb"; //option b
    private SQLiteDatabase myDatabase;

    public DBAdapterSeven(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        myDatabase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTIONSeven + " ( "
                + KEY_IDseven + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESIONseven
                + " TEXT, " + KEY_ANSWERseven+ " TEXT, "+KEY_OPTAseven +" TEXT, "
                +KEY_OPTBseven +" TEXT)";
//        drop older table if it existed
        db.execSQL(sql);
//        create new table
        addQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONSeven);

        // Create tables again
        onCreate(db);
    }

    public int rowCount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTIONSeven;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

    public List<Question> getSevenQuestions() {

        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTIONSeven;
        myDatabase=this.getReadableDatabase();

        Cursor cursor = myDatabase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setId(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOptionA(cursor.getString(3));
                quest.setOptionB(cursor.getString(4));

                quesList.add(quest);

            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    private void addQuestions() {
        //format is question-option1-option2-answer
        Question q1=new Question("Can your child do A7?","yes", "no","yes");
        this.addQuestion(q1);

        Question q2=new Question("Can your child do B7?","yes ", "no", "yes");
        this.addQuestion(q2);

        Question q3=new Question("Can your child do C7?","yes ", "no", "yes");
        this.addQuestion(q3);

        Question q4=new Question("Can your child do D7?","yes ", "no", "yes");
        this.addQuestion(q4);

        Question q5=new Question("Can your child do E7?","yes ", "no", "yes");
        this.addQuestion(q5);

    }

    // Adding new question
    public void addQuestion(Question quest) {

        ContentValues values = new ContentValues();
        values.put(KEY_QUESIONseven, quest.getQUESTION());
        values.put(KEY_ANSWERseven, quest.getANSWER());
        values.put(KEY_OPTAseven, quest.getOptionA());
        values.put(KEY_OPTBseven, quest.getOptionB());

        // Inserting Row
        myDatabase.insert(TABLE_QUESTIONSeven, null, values);
    }

}
