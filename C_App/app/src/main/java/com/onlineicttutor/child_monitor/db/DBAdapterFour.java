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
public class DBAdapterFour extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "childmonitorquizfour";

    // Table name
    private static final String TABLE_QUESTIONFour = "questionfour";

    // Table Columns names
    private static final String KEY_IDfour = "id";
    private static final String KEY_QUESIONfour = "questionfour";
    private static final String KEY_ANSWERfour = "answerfour"; //correct option
    private static final String KEY_OPTAfour= "optafour"; //option a
    private static final String KEY_OPTBfour= "optbfour"; //option b
    private SQLiteDatabase myDatabase;

    public DBAdapterFour(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        myDatabase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTIONFour + " ( "
                + KEY_IDfour + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESIONfour
                + " TEXT, " + KEY_ANSWERfour+ " TEXT, "+KEY_OPTAfour +" TEXT, "
                +KEY_OPTBfour +" TEXT)";
//        drop older table if it existed
        db.execSQL(sql);
//        create new table
        addQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONFour);

        // Create tables again
        onCreate(db);
    }

    public int rowCount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTIONFour;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

    public List<Question> getFourQuestions() {

        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTIONFour;
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
        Question q1=new Question("Can your child do A12?","yes", "no","yes");
        this.addQuestion(q1);

        Question q2=new Question("Can your child do B12?","yes ", "no", "yes");
        this.addQuestion(q2);

        Question q3=new Question("Can your child do C12?","yes ", "no", "yes");
        this.addQuestion(q3);

        Question q4=new Question("Can your child do D12?","yes ", "no", "yes");
        this.addQuestion(q4);

        Question q5=new Question("Can your child do E12?","yes ", "no", "yes");
        this.addQuestion(q5);

    }

    // Adding new question
    public void addQuestion(Question quest) {

        ContentValues values = new ContentValues();
        values.put(KEY_QUESIONfour, quest.getQUESTION());
        values.put(KEY_ANSWERfour, quest.getANSWER());
        values.put(KEY_OPTAfour, quest.getOptionA());
        values.put(KEY_OPTBfour, quest.getOptionB());

        // Inserting Row
        myDatabase.insert(TABLE_QUESTIONFour, null, values);
    }

}
