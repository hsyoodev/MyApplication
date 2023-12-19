package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    EditText editText;
    Button button;
    RadioButton radioButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.isNull(radioButton)) {
                    Toast.makeText(MainActivity.this, "radio is null", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("q1", radioButton.getText().toString());
                    intent.putExtra("q2", editText.getText().toString());
                    startActivity(intent);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
            }
        });
    }
}