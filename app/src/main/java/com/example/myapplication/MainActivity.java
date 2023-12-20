package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.button);
        Button button = (Button) view;

        Button button2 = findViewById(R.id.button);

        mp = MediaPlayer.create(MainActivity.this, R.raw.music);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 기능 작성
                System.out.println("버튼 클릭");
                if (mp.isPlaying()) {
                    mp.pause();
                } else {
                    mp.start();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }
}
