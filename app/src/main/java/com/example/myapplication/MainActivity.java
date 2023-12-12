package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox android;
    CheckBox apple;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android = findViewById(R.id.android);
        apple = findViewById(R.id.apple);
        toggleButton = findViewById(R.id.toggle);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("toggle", String.valueOf(isChecked));
                if (isChecked) {
                    android.setChecked(false);
                    apple.setChecked(false);
                } else {
                    android.setChecked(true);
                    apple.setChecked(true);
                }
            }
        });

        android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.w("android", String.valueOf(isChecked));
            }
        });

        apple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.w("apple", String.valueOf(isChecked));
            }
        });
    }
}