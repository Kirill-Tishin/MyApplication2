package com.example.myapplication2.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Calendar;

public class DbHelper extends SQLiteOpenHelper {
    private SQLiteDatabase database;

    public DbHelper(Context context) {
        super(context, "incexp", null, 1);
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

    public String getNameTable() {
        return "sum_inc";
    }

    public void insertTable(ContentValues contentValues) {
        database.insert(getNameTable(), null, contentValues);
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    //Удаление записи по id
    public void deleteRecord(long idSum) {//todo либо передаем id либо класс, откуда получаем id смотря что получиться брать с формы, когда заполняется форма
        database.delete(getNameTable(), "sum_id = " + idSum, null);
    }

    //Изменение записи по id
    public void updateRecord(long idSum, ContentValues contentValues) {
        database.update(getNameTable(), contentValues, "sum_id = " + idSum, null);
    }

    //Получение записи по id
    public SumInc getSumIncForId(long id) {
        SumInc sumInc = null;
        ArrayList<SumInc> arrayList = getAllElements();
        for (int i = 0; i < arrayList.size(); i++) {
            if(id==arrayList.get(i).getSumId()){
                sumInc=arrayList.get(i);
            }
        }
        return sumInc;
    }

    public void printAllElements(){
        ArrayList<SumInc> arrayList = getAllElements();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).getSumId()+"  "+arrayList.get(i).getTitle()+" "+arrayList.get(i).getSumm()+"  "+arrayList.get(i).getDescription()+"  "+arrayList.get(i).getUrlImage()+"  "+arrayList.get(i).getUrlLocation());
            System.out.println();
        }
    }

    //Получение всех элементов из БД
    public ArrayList<SumInc> getAllElements() {
        ArrayList<SumInc> list = new ArrayList<SumInc>();
        String selectQuery = "SELECT * FROM " + getNameTable();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                if (cursor.moveToFirst()) {
                    do {
                        SumInc sumInc = new SumInc();
                        sumInc.setSumId(Integer.parseInt(cursor.getString(0)));
                        sumInc.setTitle(cursor.getString(1));
                        sumInc.setDescription(cursor.getString(2));
                        sumInc.setSumm(Long.parseLong(cursor.getString(3)));
                        sumInc.setUrlImage(cursor.getString(4));
                        sumInc.setUrlLocation(cursor.getString(5));
                        sumInc.setDateTimeLong(cursor.getLong(6));

                        list.add(sumInc);
                    } while (cursor.moveToNext());
                }
            } finally {
                try {
                   // cursor.close();
                } catch (Exception ignore) {
                }
            }
        } finally {
            try {
             //   db.close();
            } catch (Exception ignore) {
            }
        }
        return list;
    }

}
