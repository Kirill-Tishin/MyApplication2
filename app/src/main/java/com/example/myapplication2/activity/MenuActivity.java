package com.example.myapplication2.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.myapplication2.R;
import com.example.myapplication2.dataBase.DbHelper;

public class MenuActivity extends Activity {

    private TextView textView; //вывод всех денег на данный момент
    private Button buttonAdd;
    private ListView listViewAllRecord;
    private Cursor cursor;
    private SimpleCursorAdapter simpleCursorAdapter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.menu);

        this.textView = findViewById(R.id.textViewYouSum);
        this.buttonAdd = findViewById(R.id.addRecordSum);
        this.listViewAllRecord = findViewById(R.id.listViewAllRecord);

        DbHelper dbHelper = new DbHelper(this);

        cursor=dbHelper.getDatabase().rawQuery("select rowid _id, title, summ from sum_inc",null);//todo исправить на получение всего селекта, потом
        cursor.moveToFirst();

        //Настройка листа на 2 колонки
        String[] from = new String[] {"summ", "title"};
        int[] to = new int[] { R.id.sumRecord, R.id.titleRecord };

        //Проход по всем записям и записывание их в курсор
        if (cursor.moveToFirst()) {

            int indexTitle = cursor.getColumnIndex("title");
            int indexSum = cursor.getColumnIndex("summ");

            while (!cursor.isAfterLast()) {
                String title = cursor.getString(indexTitle);
                String sum = cursor.getString(indexSum);

                //Вывод, который нормально нужно переделать в лист
                System.out.println();
                System.out.println(title+"  "+sum);
                System.out.println();

                cursor.moveToNext();
            }
        }

        //Настройка курсора адаптера для отображения//todo WTF????
        simpleCursorAdapter = new SimpleCursorAdapter(this,R.layout.item_record,cursor,from,to);
        listViewAllRecord.setAdapter(simpleCursorAdapter);

        // добавляем контекстное меню к списку
        registerForContextMenu(listViewAllRecord);

        cursor.close();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ChoiceMoney.class);
                startActivity(intent);
            }
        });
    }
}
