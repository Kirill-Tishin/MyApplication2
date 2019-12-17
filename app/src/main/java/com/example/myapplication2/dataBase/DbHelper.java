package com.example.myapplication2.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private SQLiteDatabase database;

    public DbHelper(Context context){
        super(context,"incexp",null,1);
        database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE sum_inc (" +
                "sum_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title VARCHAR(50)," +
                "description VARCHAR(200)," +
                "summ long NOT NULL," +
                "url_image VARCHAR(200)," +
                "url_geolocate VARCHAR(200)," +
                "date_sum DATE," +
                "time_sum TIME" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String getNameTable(){
        return "sum_inc";
    }

    public void insertTable(ContentValues contentValues){
        database.insert(getNameTable(),null,contentValues);
    }

    public SQLiteDatabase getDatabase(){
        return database;
    }
}
