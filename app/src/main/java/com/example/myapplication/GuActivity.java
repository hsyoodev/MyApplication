package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class GuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gu);

        LinearLayout layout = findViewById(R.id.gu);
        Intent intent = getIntent();
        HashMap<String, ArrayList<AddressVO>> hashMap = (HashMap<String, ArrayList<AddressVO>>) intent.getSerializableExtra("hashMap");

        ArrayList<AddressVO> addressVOs = null;
        if (hashMap.containsKey("서울")) {
            addressVOs = hashMap.get("서울");
        } else {
            addressVOs = hashMap.get("부산");
        }

        for (AddressVO addressVO : addressVOs) {
            String gu = addressVO.getGu();
            int count = addressVO.getCount();
            Button button = new Button(GuActivity.this);
            button.setText(String.format("%s/동:%s", gu, count));
            layout.addView(button);
        }
    }
}