package com.example.myapplication2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.R;

public class ChoiceMoney extends Activity {

    private Button buttonPlusMoney;
    private Button buttonMinusMoney;
    private Button buttonMap;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.choice_money);

        this.buttonPlusMoney = findViewById(R.id.buttonPlusMoney);
        this.buttonMinusMoney = findViewById(R.id.buttonMinusMoney);
        this.buttonMap = findViewById(R.id.buttonMap);

        buttonPlusMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceMoney.this, AddMoney.class);
                intent.putExtra("flag",true);
                startActivity(intent);
            }
        });

        buttonMinusMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceMoney.this, AddMoney.class);
                intent.putExtra("flag",false);
                startActivity(intent);
            }
        });

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
