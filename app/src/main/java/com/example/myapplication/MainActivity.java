package com.example.myapplication;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button prev, next;

    TextView textView;

    int num = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        textView = findViewById(R.id.textView);

        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this, permissions, MODE_PRIVATE);

        File f = new File("/sdcard/Pictures");
        File[] list = f.listFiles();
        for (File file : list) {
            Log.e("file", file.getName());
        }

        File first = list[Math.min(9, num++)];
        Bitmap bitmap = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            bitmap = BitmapFactory.decodeStream(new FileInputStream(first), null, options);
        } catch (FileNotFoundException e) {
            Log.e("error", "에러남");
            e.printStackTrace();
        }
        imageView.setImageBitmap(bitmap);

        textView.setText(String.format("%s / %s", num, list.length - 1));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num >= list.length - 1) {
                    num = 0;
                }
                Log.e("num", String.valueOf(num));
                File first = list[num++];
                Bitmap bitmap = null;
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    bitmap = BitmapFactory.decodeStream(new FileInputStream(first), null, options);
                } catch (FileNotFoundException e) {
                    Log.e("error", "에러남");
                    e.printStackTrace();
                }
                imageView.setImageBitmap(bitmap);

                textView.setText(String.format("%s / %s", num, list.length - 1));
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num < 0) {
                    num = list.length - 1;
                }
                Log.e("num--", String.valueOf(num));
                File first = list[num--];
                Bitmap bitmap = null;
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    bitmap = BitmapFactory.decodeStream(new FileInputStream(first), null, options);
                } catch (FileNotFoundException e) {
                    Log.e("error", "에러남");
                    e.printStackTrace();
                }
                imageView.setImageBitmap(bitmap);

                textView.setText(String.format("%s / %s", num, list.length - 1));
            }
        });
    }
}