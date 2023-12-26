package com.example.myapplication;

import android.Manifest;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] per = {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        ActivityCompat.requestPermissions(this, per, MODE_PRIVATE);
        
        TextView content = (TextView) findViewById(R.id.content);
        DBHelper dbHelper = new DBHelper(this);
        List<Map<String, Object>> list = dbHelper.select();
        for (int i = 0; i < list.size(); i++) {
            content.append("===========================\n");
            content.append(list.get(i).toString() + "\n");
        }
    }
}