package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText editId;
    EditText editName;
    CheckBox checkAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editId = (EditText) findViewById(R.id.edit_id);
        editName = (EditText) findViewById(R.id.edit_name);
        checkAgree = (CheckBox) findViewById(R.id.check_agree);
        sp = getSharedPreferences("myData", MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String id = sp.getString("id", "");
        String name = sp.getString("name", "");
        boolean isAgree = sp.getBoolean("isAgree", false);
        editId.setText(id);
        editName.setText(name);
        checkAgree.setChecked(isAgree);
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
}