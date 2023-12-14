package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start, stop;
        final ViewFlipper vFlipper;

        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);

        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        vFlipper.setFlipInterval(1000);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!vFlipper.isFlipping()) {
                    vFlipper.startFlipping();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (vFlipper.isFlipping()) {
                    vFlipper.stopFlipping();
                }
            }
        });
    }
}