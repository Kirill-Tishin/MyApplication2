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

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.choice_money);

        this.buttonPlusMoney = findViewById(R.id.buttonPlusMoney);
        this.buttonMinusMoney = findViewById(R.id.buttonMinusMoney);

        buttonPlusMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceMoney.this, AddMoney.class);
                startActivity(intent);
            }
        });

        buttonMinusMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Тут флаг с передачей минуса
                Intent intent = new Intent(ChoiceMoney.this, AddMoney.class); ///test
                startActivity(intent);
            }
        });
    }
}
