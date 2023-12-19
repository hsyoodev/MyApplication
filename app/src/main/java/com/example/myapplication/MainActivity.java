package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("text", "문장~~~~");
                intent.putExtra("number", 23.24f);

                DataVO vo = new DataVO();
                vo.title = "제목1";
                vo.hit = 100;
                intent.putExtra("data", vo);

                InfoVO vo2 = new InfoVO();
                vo2.setId("hello");
                vo2.setPw("world");
                intent.putExtra("info", vo2);
                
                startActivity(intent);
            }
        });
    }
}