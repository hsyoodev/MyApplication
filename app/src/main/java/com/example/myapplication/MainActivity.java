package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm; // android.support.v4.app.FragmentManager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        Button btnFirst = (Button) findViewById(R.id.btn_first);
        Button btnSecond = (Button) findViewById(R.id.btn_second);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(
                        R.id.layout_fragment, new FirstFragment()).commit();
            }
        });
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // android.support.v4.app.FragmentTransaction
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.layout_fragment, new SecondFragment());
                ft.commit();
            }
        });
    }
}
