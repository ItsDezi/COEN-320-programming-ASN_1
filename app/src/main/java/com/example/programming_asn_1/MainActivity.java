package com.example.programming_asn_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    AppCompatButton settingsBut,count1, count2, count3, showCountBut;
    TextView totalCountMainPage;
    protected SharedPreferenceHelper spHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spHelper = new SharedPreferenceHelper(MainActivity.this);
        count1 = findViewById(R.id.event1Button);
        count2 = findViewById(R.id.event2Button);
        count3 = findViewById(R.id.event3Button);
        totalCountMainPage = findViewById(R.id.mainPageTotalCount);

        count1.setText(spHelper.getCounter1Name());
        count2.setText(spHelper.getCounter2Name());
        count3.setText(spHelper.getCounter3Name());
        totalCountMainPage.setText("Total Count: " + spHelper.getTotalCount());

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
        count1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spHelper.saveCount1(spHelper.getCount1() + 1);
                totalCountMainPage.setText("Total Count: " + spHelper.getTotalCount());

            }
        });
        count2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spHelper.saveCount2(spHelper.getCount2() + 1);
                totalCountMainPage.setText("Total Count: " + spHelper.getTotalCount());
            }
        });
        count3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spHelper.saveCount3(spHelper.getCount3() + 1);
                totalCountMainPage.setText("Total Count: " + spHelper.getTotalCount());
            }
        });
        }
}