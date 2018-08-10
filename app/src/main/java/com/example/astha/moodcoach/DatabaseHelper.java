package com.example.astha.moodcoach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.astha.moodcoach.AppController.TAG;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name="User3w.db";
    public static final String Table_Name="Userr_table";
    public static final String Col_1 ="ID";
    public static final String Col_2 ="MOOD";

    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, MOOD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);

        onCreate(db);
    }

    public boolean insertData(String two)
    {  SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_2,two);
        Log.d("valuessss",two);
        long result=db.insert(Table_Name,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+Table_Name,null);
        return res;
    }

}