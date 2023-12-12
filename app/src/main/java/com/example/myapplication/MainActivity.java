package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMove = (Button) findViewById(R.id.btn_move);
        final ImageView img1 = (ImageView) findViewById(R.id.img1);
        Button btnRotate = (Button) findViewById(R.id.btn_rotate);
        final ImageView img2 = (ImageView) findViewById(R.id.img2);
        Button btnZoom = (Button) findViewById(R.id.btn_zoom);
        final ImageView img3 = (ImageView) findViewById(R.id.img3);
        Button btnFade = (Button) findViewById(R.id.btn_fade);
        final ImageView img4 = (ImageView) findViewById(R.id.img4);
        Button btnMove2 = (Button) findViewById(R.id.btn_move2);
        final ImageView img5 = (ImageView) findViewById(R.id.img5);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move);
                img1.startAnimation(ani);
            }
        });
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                img2.startAnimation(ani);
            }
        });
        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom);
                img3.startAnimation(ani);
            }
        });

        btnFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade);
                img4.startAnimation(ani);
            }
        });
        btnMove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation ani = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move2);
                img5.startAnimation(ani);
            }
        });
    }
}