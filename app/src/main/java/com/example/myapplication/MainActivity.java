package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RelativeLayout baseLayout;
    EditText editText;
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기(컨텍스트 메뉴)");
        baseLayout = findViewById(R.id.baseLayout);
        editText = findViewById(R.id.edtAngle);
        imageView = findViewById(R.id.imageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.setChecked(true);
        int itemId = item.getItemId();
        imageView.setRotation(Float.parseFloat(editText.getText().toString()));
        InputMethodManager inputManager = (InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        if (itemId == R.id.item1) {
            imageView.setImageResource(R.drawable.hanla);
            return true;
        } else if (itemId == R.id.item2) {
            imageView.setImageResource(R.drawable.chuja);
            return true;
        } else if (itemId == R.id.item3) {
            imageView.setImageResource(R.drawable.beom);
            return true;
        }
        return false;
    }
}