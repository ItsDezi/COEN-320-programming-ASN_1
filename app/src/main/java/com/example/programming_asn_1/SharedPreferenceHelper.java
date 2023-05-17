package com.example.programming_asn_1;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {

    private SharedPreferences sharedPreferences;
    public SharedPreferenceHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("sharedPreference", Context.MODE_PRIVATE );
    }

    public void saveCounter1Name(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counter1Name",name );
        editor.commit();
    }
    public void saveCounter2Name(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counter2Name",name );
        editor.commit();
    }
    public void saveCounter3Name(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counter3Name",name );
        editor.commit();
    }
    public String getCounter1Name()
    {
        return sharedPreferences.getString("counter1Name", null);
    }
    public String getCounter2Name()
    {
        return sharedPreferences.getString("counter2Name", null);
    }
    public String getCounter3Name()
    {
        return sharedPreferences.getString("counter3Name", null);
    }
}
