package com.example.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        DBHelper dbHelper = new DBHelper(this);
        List<Map<String, Object>> list = dbHelper.select();
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, R.layout.item, list);
        listView.setAdapter(listViewAdapter);
    }
}

class DBHelper extends SQLiteOpenHelper {
    private final String dbName = "busan.db";

    public DBHelper(Context context) {
        super(context, "busan.db", null, 1);
        
        if (!isExistDB(context)) { // 앱 처음 실행 (DB 데이터 없음)
            copyDB(context); // DB 데이터 생성 (복사)
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean isExistDB(Context context) {
        String packageName = context.getPackageName();
        String filePath = "/data/data/" + packageName + "/databases/" + dbName;
        File file = new File(filePath);
        if (file.exists()) {
            return true;
        }
        return false;
    }

    public void copyDB(Context context) {
        AssetManager manager = context.getAssets();
        String packageName = context.getPackageName();
        String folderPath = "/data/data/" + packageName + "/databases";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        InputStream is = null;
        BufferedInputStream bis = null;
        OutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            is = manager.open(dbName);
            bis = new BufferedInputStream(is);
            fos = new FileOutputStream(folderPath + "/" + dbName);
            bos = new BufferedOutputStream(fos);
            int data = 0;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public List<Map<String, Object>> select() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM shop", null);
        while (cursor.moveToNext()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("shop_id", cursor.getInt(0));
            map.put("shop_name", cursor.getString(1));
            map.put("shop_desc", cursor.getString(2));
            map.put("rest_date", cursor.getString(3));
            map.put("parking_info", cursor.getString(4));
            map.put("img_path", cursor.getString(5));
            list.add(map);
        }
        db.close();
        return list;
    }

}
