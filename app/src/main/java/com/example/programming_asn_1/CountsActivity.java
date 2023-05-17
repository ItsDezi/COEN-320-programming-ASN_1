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
import android.widget.TextView;

public class CountsActivity extends AppCompatActivity {

    boolean eventNameEnabled = true;
    TextView tv1, tv2, tv3, totalEvents;
    protected SharedPreferenceHelper spHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counts);

        //linking XML to Java objects
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        totalEvents = findViewById(R.id.totalEvents);
        spHelper = new SharedPreferenceHelper(CountsActivity.this);

        //retrieving saved data
        totalEvents.setText("Total Events: " + spHelper.getTotalCount());
        tv1.setText(spHelper.getCounter1Name() + ": " + spHelper.getCount1());
        tv2.setText(spHelper.getCounter2Name() + ": " + spHelper.getCount2());
        tv3.setText(spHelper.getCounter3Name() + ": " + spHelper.getCount3());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CountsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.counts_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.eventNamesOption)
        {
            eventNameEnabled = !eventNameEnabled;
            if(eventNameEnabled)
            {
                tv1.setText(spHelper.getCounter1Name() + ": " + spHelper.getCount1());
                tv2.setText(spHelper.getCounter2Name() + ": " + spHelper.getCount2());
                tv3.setText(spHelper.getCounter3Name() + ": " + spHelper.getCount3());
            }
            else
            {
                tv1.setText("Counter 1" + ": " + spHelper.getCount1());
                tv2.setText("Counter 2" + ": " + spHelper.getCount2());
                tv3.setText("Counter 3" + ": " + spHelper.getCount3());
            }
        }
        return super.onOptionsItemSelected(item);
    }
}