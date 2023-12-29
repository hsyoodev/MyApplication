package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    long basetime;
    long remaintime;
    TextView text;
    Button start, stop;
    boolean isRunning = false;
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            String time = getTime();
            text.setText(time);
            if (isRunning) {
                handler.sendEmptyMessage(0);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basetime = SystemClock.elapsedRealtime();
                isRunning = true;
                handler.sendEmptyMessage(0);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
            }
        });
    }

    private String getTime() {
        long now = SystemClock.elapsedRealtime();
        long remain = now + remaintime - basetime;
        if (!isRunning) {
            remaintime = remain;
        }
        long min = remain / 1000 / 60;
        long sec = (remain / 1000) % 60;
        long milliSec = (remain % 1000) / 10; // 소수점 둘째 자리까지 표시
        String timeFormat = String.format("%02d:%02d:%02d", min, sec, milliSec);
        return timeFormat;
    }
}
