package com.example.myapplication2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication2.R;

public class InformForRecord extends Activity {
    private TextView textViewYouSum;
    private TextView dateAndTime;
    private EditText editTextSum;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private ImageView imageSum;
    private ImageView imageMap;
    private Button deleteRecordSum;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.inform_for_record);

        this.textViewYouSum = findViewById(R.id.textViewYouSum);
        this.dateAndTime = findViewById(R.id.dateAndTime);
        this.editTextSum = findViewById(R.id.editTextSum);
        this.editTextTitle = findViewById(R.id.editTextTitle);
        this.editTextDescription = findViewById(R.id.editTextDescription);
        this.imageSum = findViewById(R.id.imageSum);
        this.imageMap = findViewById(R.id.imageMap);
        this.deleteRecordSum = findViewById(R.id.deleteRecordSum);
    }
}
