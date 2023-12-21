package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        String[] data = {"원피스", "나루토", " 블리치", "드래곤볼", "원피스", "나루토", " 블리치", "드래곤볼", "원피스", "나루토", " 블리치", "드래곤볼", "원피스", "나루토", " 블리치", "드래곤볼", "원피스", "나루토", " 블리치", "드래곤볼"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setTitle(data[position]);
                ab.show();
            }
        });

        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, data);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter2);
    }
}
