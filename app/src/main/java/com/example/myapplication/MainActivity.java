package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText editId;
    EditText editName;
    CheckBox checkAgree;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editId = (EditText) findViewById(R.id.edit_id);
        editName = (EditText) findViewById(R.id.edit_name);
        checkAgree = (CheckBox) findViewById(R.id.check_agree);
        sp = getSharedPreferences("myData", MODE_PRIVATE);
        textView = findViewById(R.id.date);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String id = sp.getString("id", "");
        String name = sp.getString("name", "");
        boolean isAgree = sp.getBoolean("isAgree", false);
        String date = sp.getString("date", "");
        editId.setText(id);
        editName.setText(name);
        checkAgree.setChecked(isAgree);
        textView.setText(date);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String id = editId.getText().toString();
        String name = editName.getText().toString();
        boolean isAgree = checkAgree.isChecked();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("id", id);
        editor.putString("name", name);
        editor.putBoolean("isAgree", isAgree);
        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Date now = new Date();
        SharedPreferences.Editor editor = sp.edit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY년 MM월 dd일 HH시 mm분 ss초");
        editor.putString("date", simpleDateFormat.format(now));
        editor.commit();
    }
}