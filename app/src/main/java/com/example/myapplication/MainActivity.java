package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    myDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new myDBHelper(this);

        dp = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnWrite = findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        String fileName = year + "_" + (month + 1) + "_" + day + ".txt";
        try {
//      FileInputStream inFs = openFileInput(fileName);
            FileInputStream inFs = new FileInputStream("/sdcard/myDiary/" + fileName);

            byte[] buf = new byte[4096];
            inFs.read(buf);

            inFs.close();
            String text = new String(buf);
            edtDiary.setText(text);
            Log.w("text", text);
        } catch (FileNotFoundException e) {
            Log.w("예외", "파일 없음");
            edtDiary.setText("");
            edtDiary.setHint("파일 없음, 내용을 작성해주세요");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view,
                                      int year, int monthOfYear, int dayOfMonth) {
                Log.w("date", "" + year + (monthOfYear + 1) + dayOfMonth);
                String fileName = year + "_" + (monthOfYear + 1) + "_" + dayOfMonth + ".txt";
                try {
//          FileInputStream inFs = openFileInput(fileName);
                    FileInputStream inFs = new FileInputStream("/sdcard/myDiary/" + fileName);

                    byte[] buf = new byte[4096];
                    inFs.read(buf);

                    inFs.close();
                    String text = new String(buf);
                    edtDiary.setText(text);
                    Log.w("text", text);
                } catch (FileNotFoundException e) {
                    Log.w("예외", "파일 없음");
                    edtDiary.setText("");
                    edtDiary.setHint("파일 없음, 내용을 작성해주세요");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = dp.getYear();
                int month = dp.getMonth() + 1;
                int day = dp.getDayOfMonth();
                String content = edtDiary.getText().toString();

                helper.insert(year, month, day, content);
            }
        });

    }

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "diary.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table diary (" +
                    "id integer primary key autoincrement, " +
                    "year text, month text, date text, content text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public void insert(
                int year, int month, int date, String content) {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("insert into diary values (" +
                    "null, '" + year + "', " +
                    "'" + month + "', " +
                    "'" + date + "', " +
                    "'" + content + "')");
            db.close();
        }
    }

}
