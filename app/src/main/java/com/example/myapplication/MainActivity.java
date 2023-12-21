package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        List<Product> list = new ArrayList<>();
        Product p = new Product();
        p.setIcon(android.R.drawable.star_on);
        p.setTitle("1번 물품");
        p.setUrl("http://www.google.com");
        list.add(p);
        list.add(new Product(android.R.drawable.btn_star, "2번 물품", "http://www.naver.com"));
        list.add(new Product(android.R.drawable.alert_light_frame, "3번 물품", "http://www.naver.com"));
        list.add(new Product(android.R.drawable.star_big_off, "4번 물품", "http://www.naver.com"));
        list.add(new Product(android.R.drawable.button_onoff_indicator_on, "5번 물품", "http://www.naver.com"));
        list.add(new Product(android.R.drawable.arrow_up_float, "6번 물품", "http://www.naver.com"));

        CustomAdapter adapter =
                new CustomAdapter(
                        this, R.layout.custom_listview, list);

        listView.setAdapter(adapter);
    }
}