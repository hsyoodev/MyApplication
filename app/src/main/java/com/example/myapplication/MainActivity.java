package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDBHelper helper = new myDBHelper(this);
        Button btnInsert = findViewById(R.id.btnInsert);
        EditText edtName = findViewById(R.id.edtName);
        EditText edtNumber = findViewById(R.id.edtNumber);
        Button btnSelect = findViewById(R.id.btnSelect);
        EditText edtNameResult = findViewById(R.id.edtNameResult);
        EditText edtNumberResult = findViewById(R.id.edtNumberResult);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("insert into groupDB values ('" +
                        edtName.getText().toString() +
                        "', " + edtNumber.getText().toString() + ");");
                db.close();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select gName, gNumber from groupDB", null);
                String gName = "";
                String gNumber = "";
                while (cursor.moveToNext()) {
                    gName += cursor.getString(0) + "\n";
                    gNumber += cursor.getString(1) + "\n";
                }
                edtNameResult.setText(gName);
                edtNumberResult.setText(gNumber);
                cursor.close();
                db.close();
            }
        });
    }

    public class myDBHelper extends SQLiteOpenHelper {

        public myDBHelper(@Nullable Context context) {
            super(context, "groupDB.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupDB (gName char(20) primary key, gNumber integer);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}