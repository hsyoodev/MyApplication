package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();
        final int num1 = inIntent.getIntExtra("Num1", 0);
        final int num2 = inIntent.getIntExtra("Num2", 0);
        final String operation = inIntent.getStringExtra("operation");
        int hapValue = 0;

        if (operation.equals("더하기")) {
            hapValue = num1 + num2;
        } else if (operation.equals("빼기")) {
            hapValue = num1 - num2;
        } else if (operation.equals("곱하기")) {
            hapValue = num1 * num2;
        } else {
            hapValue = num1 / num2;
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        int finalHapValue = hapValue;
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                outIntent.putExtra("Hap", finalHapValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}