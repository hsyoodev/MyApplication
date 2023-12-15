package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, R.string.app_name, Toast.LENGTH_SHORT);
                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                View view = layoutInflater.inflate(R.layout.toast, null);
                toast.setView(view);
                toast.show();
            }
        });
    }
}