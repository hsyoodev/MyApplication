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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button a, b, c, d;
    TextView clock;
    int target = 1;
    boolean isRunning;
    long baseTime;
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            String time = getTime();
            clock.setText(time);
            if (isRunning) {
                handler.sendEmptyMessage(0);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        clock = findViewById(R.id.clock);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);

        baseTime = SystemClock.elapsedRealtime();
        isRunning = true;
        handler.sendEmptyMessage(0);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        int number = Integer.parseInt(button.getText().toString());
        if (target++ == number) {
            button.setText(number + 4 + "");
        }
        if (target + 4 > 8) {
            AlertDialog.Builder ab = new AlertDialog.Builder(this);
            ab.setMessage("종료");
            ab.show();
            isRunning = false;
        }
    }

    private String getTime() {
        long now = SystemClock.elapsedRealtime();
        long remain = now - baseTime;
        long min = remain / 1000 / 60;
        long sec = (remain / 1000) % 60;
        long milliSec = (remain % 1000) / 10; // 소수점 둘째 자리까지 표시
        String timeFormat = String.format("%02d:%02d:%02d", min, sec, milliSec);
        return timeFormat;
    }
}
