package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        float number = intent.getFloatExtra("number", 0);

        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle(text);
        ab.setMessage(number + "");
        ab.show();
    }
}