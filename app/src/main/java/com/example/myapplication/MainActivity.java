package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");

        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String name = String.format("%s년_%s월_%s일", year, (monthOfYear + 1), dayOfMonth);
                try {
                    FileInputStream inFs = openFileInput(name);
                    byte[] buf = new byte[4096];
                    inFs.read(buf);
                    inFs.close();
                    String text = new String(buf);
                    Log.w("text", text);
                    edtDiary.setText(text);
                } catch (FileNotFoundException e) {
                    Log.w("예외", "파일 없음");
                    edtDiary.setText("");
                    edtDiary.setHint("파일 없음, 내용을 작성해주세요.");
                } catch (IOException e) {
                    Log.w("IOException", "error");
                }
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = dp.getYear();
                int month = dp.getMonth() + 1;
                int day = dp.getDayOfMonth();
                String name = String.format("%s년_%s월_%s일", year, month, day);
                FileOutputStream outFs = null;
                try {
                    outFs = openFileOutput(name, Context.MODE_PRIVATE);
                    outFs.write("쿡북 안드로이드".getBytes());
                    outFs.write(edtDiary.getText().toString().getBytes());
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "쿡북 안드로이드", Toast.LENGTH_SHORT).show();
                } finally {
                    try {
                        outFs.close();
                        Toast.makeText(MainActivity.this, "잘 써짐", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        Toast.makeText(MainActivity.this, "쓰다 에러남", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}