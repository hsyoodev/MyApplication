package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("sub", "create");
        setContentView(R.layout.activity_sub);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("sub", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("sub", "pause");
    }
}