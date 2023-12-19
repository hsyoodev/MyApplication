package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton second, third;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                if (second.isChecked()) {
                    intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                if (third.isChecked()) {
                    intent = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(intent);
                }
            }
        });
    }
}