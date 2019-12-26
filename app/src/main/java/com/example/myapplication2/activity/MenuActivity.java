package com.example.myapplication2.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.myapplication2.R;
import com.example.myapplication2.dataBase.DbHelper;

import java.util.Calendar;
import java.util.Date;

public class MenuActivity extends Activity {

    private TextView textView; //вывод всех денег на данный момент
    private Button buttonAdd;
    private ListView listViewAllRecord;
    private Cursor cursor;
    private SimpleCursorAdapter simpleCursorAdapter;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.menu);

        this.textView = findViewById(R.id.textViewYouSum);
        this.buttonAdd = findViewById(R.id.addRecordSum);
        this.listViewAllRecord = findViewById(R.id.listViewAllRecord);

        final DbHelper dbHelper = new DbHelper(this);
        sqLiteDatabase=dbHelper.getDatabase();

        cursor = sqLiteDatabase.rawQuery("select rowid _id, title, summ from "+dbHelper.getNameTable(),null);
        String[] headers = new String[] {"summ", "title"};

        simpleCursorAdapter=new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                cursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);

        listViewAllRecord.setAdapter(simpleCursorAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ChoiceMoney.class);
                startActivity(intent);
            }
        });

        listViewAllRecord.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MenuActivity.this, InformForRecord.class);
                intent.putExtra("idRecord",id);
                startActivity(intent);
            }
        });
    }
}
