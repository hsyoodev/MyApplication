package com.example.myapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer1;
    RadioButton rdoCal, rdoTime;
    DatePicker datePicker1;
    TimePicker timePicker1;
    TextView tvYear, tvMonth, tvDay;
    TextView tvHour, tvMinute;
    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer1 = findViewById(R.id.chronometer1);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        datePicker1 = findViewById(R.id.datePicker1);
        timePicker1 = findViewById(R.id.timePicker1);

        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker1.setVisibility(View.VISIBLE);
                timePicker1.setVisibility(View.INVISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker1.setVisibility(View.INVISIBLE);
                timePicker1.setVisibility(View.VISIBLE);
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = datePicker1.getYear();
                int month = datePicker1.getMonth();
                int day = datePicker1.getDayOfMonth();
                int hour = timePicker1.getHour();
                int minute = timePicker1.getMinute();
                tvYear.setText(String.valueOf(year));
                tvMonth.setText(String.valueOf(month));
                tvDay.setText(String.valueOf(day));
                tvHour.setText(String.valueOf(hour));
                tvMinute.setText(String.valueOf(minute));
                chronometer1.stop();
            }
        });


    }
}