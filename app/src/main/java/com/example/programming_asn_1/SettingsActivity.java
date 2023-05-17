package com.example.programming_asn_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {
boolean editActive = false;
EditText counter1Name, counter2Name, counter3Name;
String counter1NameStr;
SharedPreferences sp;
AppCompatButton saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        counter1Name = findViewById(R.id.counter1);
        //counter2Name = findViewById(R.id.counter2);
        //counter3Name = findViewById(R.id.counter3);
        saveButton = (AppCompatButton) findViewById(R.id.saveSettings);
        sp = getSharedPreferences("sharedPreference", Context.MODE_PRIVATE);

        counter1Name.setText(sp.getString("counter1Name", "Not Found"));
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1NameStr = counter1Name.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("counter1Name", counter1NameStr);
                editor.commit();
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
        }
        return super.onOptionsItemSelected(item);
    }
}