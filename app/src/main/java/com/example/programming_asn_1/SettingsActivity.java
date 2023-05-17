package com.example.programming_asn_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {
boolean editActive = false;
EditText counter1Name, counter2Name, counter3Name, maxCount;
String counter1NameStr, counter2NameStr, counter3NameStr,maxCountStr;
int maxCountInt;
//SharedPreferences sp;
    protected SharedPreferenceHelper spHelper;
AppCompatButton saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        
        //linking XML to Java objects
        counter1Name = findViewById(R.id.counter1);
        counter2Name = findViewById(R.id.counter2);
        counter3Name = findViewById(R.id.counter3);
        maxCount = findViewById(R.id.maxCount);

        saveButton = (AppCompatButton) findViewById(R.id.saveSettings);
        spHelper = new SharedPreferenceHelper(SettingsActivity.this);

        //retrieving saved data
        counter1Name.setText(spHelper.getCounter1Name());
        counter2Name.setText(spHelper.getCounter2Name());
        counter3Name.setText(spHelper.getCounter3Name());
        maxCount.setText("" + spHelper.getMaxCount());

        //initializing editTexts to disabled
        counter1Name.setEnabled(editActive);
        counter2Name.setEnabled(editActive);
        counter3Name.setEnabled(editActive);
        maxCount.setEnabled(editActive);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //converting to string
                counter1NameStr = counter1Name.getText().toString();
                counter2NameStr = counter2Name.getText().toString();
                counter3NameStr = counter3Name.getText().toString();
                maxCountStr = maxCount.getText().toString();
                maxCountInt = Integer.parseInt(maxCountStr);
                //save all values
                spHelper.saveCounter1Name(counter1NameStr);
                spHelper.saveCounter2Name(counter2NameStr);
                spHelper.saveCounter3Name(counter3NameStr);
                spHelper.saveMaxCount(maxCountInt);

            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.editOption)
        {
            editActive = !editActive;
            counter1Name.setEnabled(editActive);
            counter2Name.setEnabled(editActive);
            counter3Name.setEnabled(editActive);
            maxCount.setEnabled(editActive);
        }
        return super.onOptionsItemSelected(item);
    }
}