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
    public void saveMaxCount(int num)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("maxCountVal",num );
        editor.commit();
    }
    public void saveCount1(int num)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count1Val",num );
        editor.commit();
    }
    public void saveCount2(int num)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count2Val",num );
        editor.commit();
    }
    public void saveCount3(int num)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count3Val",num );
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
    public int getMaxCount()
    {
        return sharedPreferences.getInt("maxCountVal", 0);
    }
    public int getCount1()
    {
        return sharedPreferences.getInt("count1Val", 0);
    }
    public int getCount2()
    {
        return sharedPreferences.getInt("count2Val", 0);
    }
    public int getCount3()
    {
        return sharedPreferences.getInt("count3Val", 0);
    }
    public int getTotalCount()
    {
        int tmp = getCount1() + getCount2() + getCount3();
        return tmp;
    }

}
