package com.example.programming_asn_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AppCompatButton settingsBut;
    AppCompatButton count1;
    AppCompatButton count2;
    AppCompatButton count3;
    AppCompatButton showCountBut;
    protected SharedPreferenceHelper spHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spHelper = new SharedPreferenceHelper(MainActivity.this);
        count1 = findViewById(R.id.event1Button);
        count2 = findViewById(R.id.event2Button);
        count3 = findViewById(R.id.event3Button);

        count1.setText(spHelper.getCounter1Name());
        count2.setText(spHelper.getCounter2Name());
        count3.setText(spHelper.getCounter3Name());

        settingsBut = (AppCompatButton) findViewById(R.id.settingsButton);
        showCountBut = (AppCompatButton) findViewById(R.id.showCountsButton);
        settingsBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
                //startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
        showCountBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CountsActivity.class);
                startActivity(intent);
                //startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
        }
}