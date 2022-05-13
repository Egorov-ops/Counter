package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNT = "Count";

    Button button;
    TextView tv;
    static int count = 0;
    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.Count_btn);
        tv = findViewById(R.id.Count_tv);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        count=mSettings.getInt(APP_PREFERENCES_COUNT,0);
        tv.setText(String.valueOf(count));
        button.setOnClickListener(view -> {
            count++;
            tv.setText(String.valueOf(count));
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putInt(APP_PREFERENCES_COUNT, count);
            editor.apply();
        });
    }
}