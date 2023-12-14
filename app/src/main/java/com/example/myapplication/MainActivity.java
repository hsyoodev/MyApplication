package com.example.myapplication;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.progress);
        SeekBar seekBar = findViewById(R.id.seek);
        RatingBar rating = findViewById(R.id.rating);
        progressBar.setProgress(70);
        seekBar.setProgress(80);
        rating.setRating(4.5f);
    }
}