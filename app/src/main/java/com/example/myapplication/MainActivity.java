package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button1, button2;
    Intent intent;
    RadioButton radioButton1, radioButton2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        imageView = findViewById(R.id.imageView);

        button1.setOnClickListener(view -> Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_SHORT).show());
        button2.setOnClickListener(view -> {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"));
            startActivity(intent);
        });

        radioButton1.setOnClickListener(view -> imageView.setImageResource(R.drawable.snow_corn));
        radioButton2.setOnClickListener(view -> imageView.setImageResource(R.drawable.tiramisu01));
    }
}