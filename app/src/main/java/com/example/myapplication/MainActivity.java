package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton btnA, btnB, btnC;
    ImageView a, b, c;
    ImageView aa, bb, cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        aa = findViewById(R.id.aa);
        bb = findViewById(R.id.bb);
        cc = findViewById(R.id.cc);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.setVisibility(View.VISIBLE);
                aa.setVisibility(View.VISIBLE);
                b.setVisibility(View.INVISIBLE);
                bb.setVisibility(View.INVISIBLE);
                c.setVisibility(View.INVISIBLE);
                cc.setVisibility(View.INVISIBLE);
            }
        });

    }
}