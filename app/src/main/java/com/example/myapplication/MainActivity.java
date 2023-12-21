package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        ArrayList<ShopVO> shopList = new ArrayList<>();
        ShopVO vo1 = new ShopVO(R.drawable.a, "한방왕족발", "도마에 가지런히 담긴 부드러운 족발");
        shopList.add(vo1);
        ShopVO vo2 = new ShopVO(R.drawable.b, "귀화식당", "제철 생선회와 다양한 요리가 있는 선술집");
        shopList.add(vo2);
        ShopVO vo3 = new ShopVO(R.drawable.c, "맛순대", "개금골목시장 대표 순대집");
        shopList.add(vo3);
        ShopVO vo4 = new ShopVO(R.drawable.d, "황산밀면", "밀면의 참맛을 느낄 수 있는 곳");
        shopList.add(vo4);
        ShopVO vo5 = new ShopVO(R.drawable.e, "무비오빠", "진한 멸치육수와 최고의 술안주가 있는 곳");
        shopList.add(vo5);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, R.layout.item, shopList);
        listView.setAdapter(listViewAdapter);
    }
}