package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView q1, q2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        intent = getIntent();
        q1.setText(intent.getStringExtra("q1"));
        q2.setText(intent.getStringExtra("q2"));
    }
}