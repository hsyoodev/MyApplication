package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL("http://ggoreb.com/api/youtube.jsp");
                    URLConnection conn = url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String json = "";
                    while (true) {
                        String line = br.readLine();
                        if (line == null) {
                            break;
                        }
                        json += line;
                    }
                    ObjectMapper objectMapper = new ObjectMapper();
                    Map<String, Object> youtubes = objectMapper.readValue(json, Map.class);
                    List<Map<String, Object>> items = (List<Map<String, Object>>) youtubes.get("items");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ListView listView = findViewById(R.id.list_view);
                            CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, R.layout.item, items);
                            listView.setAdapter(customAdapter);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
