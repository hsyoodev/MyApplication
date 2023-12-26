package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView lastLoginEndDate;
    SQLiteDatabase db;
    myDBHelper helper = new myDBHelper(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = helper.getReadableDatabase();
        lastLoginEndDate = findViewById(R.id.last_login_end_date);
        Cursor cursor = db.rawQuery("SELECT id, date_time FROM history ORDER BY date_time DESC", null);
        String dateTime = "";
        while (cursor.moveToNext()) {
            dateTime = cursor.getString(1);
            break;
        }
        lastLoginEndDate.setText(dateTime);
    }

    @Override
    protected void onResume() {
        super.onResume();
        db = helper.getReadableDatabase();
        lastLoginEndDate = findViewById(R.id.last_login_end_date);
        Cursor cursor = db.rawQuery("SELECT id, date_time FROM history ORDER BY date_time DESC", null);
        String dateTime = "";
        while (cursor.moveToNext()) {
            dateTime = cursor.getString(1);
            break;
        }
        lastLoginEndDate.setText(dateTime);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO history (id, date_time) VALUES (NULL, (datetime('now', 'localtime')))");
    }

    public class myDBHelper extends SQLiteOpenHelper {

        public myDBHelper(@Nullable Context context) {
            super(context, "history.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE history (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    date_time TEXT);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}