package com.example.programming_asn_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AppCompatButton settingsBut;
    AppCompatButton eventA;
    AppCompatButton eventB;
    AppCompatButton eventC;
    AppCompatButton showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingsBut = (AppCompatButton) findViewById(R.id.settingsButton);
        settingsBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
                //startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        }
}