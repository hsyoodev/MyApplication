package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

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
                    url = new URL("http://ggoreb.com/api/idol.jsp");
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
                    List<Map<String, String>> idols = objectMapper.readValue(json, List.class);
                    for (Map<String, String> idol : idols) {
                        String name = idol.get("name");
                        String agency = idol.get("agency");
                        Log.w("idol", String.format("name : %s, agency : %s", name, agency));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
