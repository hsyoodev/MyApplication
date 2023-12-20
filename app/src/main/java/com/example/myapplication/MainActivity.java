package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // HashMap 선언 및 초기화
        HashMap<String, ArrayList<AddressVO>> hashMap = new HashMap<>();
        // ArrayList 선언
        ArrayList<AddressVO> seoulAddressVOs = new ArrayList<>();
        ArrayList<AddressVO> busanAddressVOs = new ArrayList<>();
        // 서울 구 목록 입력 및 ArrayList에 추가 (강남구, 관악구, 중구, 용산구)
        String[] seoulGus = {"강남구", "강동구", "강북구", "강서구"};
        int[] seoulCounts = {15, 9, 9, 15};
        for (int i = 0; i < 4; i++) {
            seoulAddressVOs.add(new AddressVO(seoulGus[i], seoulCounts[i]));
        }
        // 부산 구 목록 입력 및 ArrayList에 추가 (금정구, 사하구, 해운대구)
        String[] busanGus = {"강서구", "금정구", "기장군", "남구"};
        int[] busanCounts = {20, 13, 5, 6};
        for (int i = 0; i < 4; i++) {
            busanAddressVOs.add(new AddressVO(busanGus[i], busanCounts[i]));
        }

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent 생성 및 서울 구 데이터 입력
                hashMap.put("서울", seoulAddressVOs);
                Intent intent = new Intent(MainActivity.this, GuActivity.class);
                intent.putExtra("hashMap", hashMap);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent 생성 및 부산 구 데이터 입력
                // startActivity() 이용 액티비티 이동
                hashMap.put("부산", busanAddressVOs);
                Intent intent = new Intent(MainActivity.this, GuActivity.class);
                intent.putExtra("hashMap", hashMap);
                startActivity(intent);
            }
        });

    }
}