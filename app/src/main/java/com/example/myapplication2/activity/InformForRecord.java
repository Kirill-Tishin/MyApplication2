package com.example.myapplication2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication2.R;
import com.example.myapplication2.dataBase.DbHelper;
import com.example.myapplication2.dataBase.SumInc;

import java.util.Objects;

public class InformForRecord extends Activity {
    private TextView textViewYouSum;
    private TextView dateAndTime;
    private TextView editTextSum;
    private TextView editTextTitle;
    private TextView editTextDescription;
    private ImageView imageSum;
    private ImageView imageMap;
    private Button deleteRecordSum;

    private DbHelper dbHelper;
    private SumInc sumInc;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.inform_for_record);

        dbHelper = new DbHelper(this);

        Bundle arguments = getIntent().getExtras();
        int idSumInc = Integer.parseInt(Objects.requireNonNull(arguments.get("idRecord")).toString());

        this.sumInc = dbHelper.getSumIncForId(idSumInc);

        this.textViewYouSum = findViewById(R.id.textViewYouSum);
        this.dateAndTime = findViewById(R.id.dateAndTime);
        this.editTextSum = findViewById(R.id.editTextSum);
        this.editTextTitle = findViewById(R.id.editTextTitle);
        this.editTextDescription = findViewById(R.id.editTextDescription);
        this.imageSum = findViewById(R.id.imageSum);
        this.imageMap = findViewById(R.id.imageMap);
        this.deleteRecordSum = findViewById(R.id.deleteRecordSum);

        editTextSum.setText(String.valueOf(sumInc.getSumm()));
        editTextTitle.setText(sumInc.getTitle());
        editTextDescription.setText(sumInc.getDescription());

    }

    public SumInc getSumInc() {
        return sumInc;
    }

    public void setSumInc(SumInc sumInc) {
        this.sumInc = sumInc;
    }

    //SumInc
}
