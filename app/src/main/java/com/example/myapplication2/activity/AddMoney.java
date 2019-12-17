package com.example.myapplication2.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication2.R;
import com.example.myapplication2.dataBase.DbHelper;
import com.example.myapplication2.dataBase.SumInc;

import java.io.File;

public class AddMoney extends Activity {

    private EditText editTextSum;
    private EditText editTextTitle;
    private Button buttonAdd;
    private Button addImage;

    private SumInc sumInc;
    private DbHelper dbHelper;
    private int cameraResult;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.add_money);

        //Сумма, название, время, описание, геолокация, фото,
        this.editTextSum = findViewById(R.id.editTextSum);
        this.buttonAdd=findViewById(R.id.buttonAdd);
        this.editTextTitle=findViewById(R.id.editTextTitle);
        this.addImage=findViewById(R.id.addImage);

        dbHelper = new DbHelper(this);
        sumInc = new SumInc();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumInc.setSumm(Long.parseLong(editTextSum.getText().toString()));
                sumInc.setTitle(editTextTitle.getText().toString());
                dbHelper.insertTable(sumInc.getContentValues());
                Intent intent = new Intent(AddMoney.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,cameraResult);

                //todo: this need save image
                sumInc.setUrlImage(String.valueOf(cameraResult));

                File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File("ImageApplication2")));
            }
        });
    }
}
