package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setMessage("종료할래?");
                ab.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                ab.setNegativeButton("아니오", null);
                ab.show();
            }
        });

        ArrayList<ShopVO> list = new ArrayList<>();
        ShopVO vo1 = new ShopVO(R.drawable.a, "한방왕족발", "도마에 가지런히 담긴 부드러운 족발");
        list.add(vo1);
        ShopVO vo2 = new ShopVO(R.drawable.b, "귀화식당", "제철 생선회와 다양한 요리가 있는 선술집");
        list.add(vo2);
        ShopVO vo3 = new ShopVO(R.drawable.c, "맛순대", "개금골목시장 대표 순대집");
        list.add(vo3);
        ShopVO vo4 = new ShopVO(R.drawable.d, "황산밀면", "밀면의 참맛을 느낄 수 있는 곳");
        list.add(vo4);
        ShopVO vo5 = new ShopVO(R.drawable.e, "무비오빠", "진한 멸치육수와 최고의 술안주가 있는 곳");
        list.add(vo5);

        for (int i = 0; i < 1000; i++) {
            ShopVO vo55 = new ShopVO(R.drawable.e, "무비오빠" + i, "진한 멸치육수와 최고의 술안주가 있는 곳");
            list.add(vo55);
        }

        ListView listView = findViewById(R.id.list_view);
        ListViewAdapter adapter = new ListViewAdapter(
                this, R.layout.item, list);
        listView.setAdapter(adapter);
    }

}