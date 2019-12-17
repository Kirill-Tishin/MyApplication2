package com.example.myapplication2.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.myapplication2.R;
import com.example.myapplication2.dataBase.DbHelper;

public class MenuActivity extends Activity {

    private TextView textView; //вывод всех денег на данный момент
    private Button buttonAdd;
    private ListView listView;
    private Cursor cursor;
    private SimpleCursorAdapter cursorAdapter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.menu);

        this.textView = findViewById(R.id.textView);
        this.buttonAdd = findViewById(R.id.buttonAdd);
        this.listView = findViewById(R.id.listView);

        DbHelper dbHelper = new DbHelper(this);

        cursor=dbHelper.getDatabase().rawQuery("select title, summ from sum_inc",null);
        cursor.moveToFirst();

        if (cursor.moveToFirst()) {

            int indexTitle = cursor.getColumnIndex("title");
            int indexSum = cursor.getColumnIndex("summ");

            while (!cursor.isAfterLast()) {
                String title = cursor.getString(indexTitle);
                String summ = cursor.getString(indexSum);

                //Вывод, который нормально нужно переделать в лист

                System.out.println();
                System.out.println(title+"  "+summ);
                System.out.println();

                

                cursor.moveToNext();
            }
        }

        cursor.close();

       // cursorAdapter = SimpleCursorAdapter(this);

       // listView.se

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ChoiceMoney.class); //choouse
                startActivity(intent);
            }
        });
    }
}
