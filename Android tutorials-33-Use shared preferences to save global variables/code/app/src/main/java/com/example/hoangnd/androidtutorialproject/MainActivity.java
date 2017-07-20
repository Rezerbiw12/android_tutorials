package com.example.hoangnd.androidtutorialproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static String globalPreferenceName = "com.hoangnd.profile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences.Editor editor = getSharedPreferences(globalPreferenceName, MODE_PRIVATE).edit();
        editor.putString("name", "Nguyen Duc Hoang");
        editor.putString("email", "sunlight4d@gmail.com");
        editor.putInt("age", 35);
        editor.commit();
//        editor.apply(); // run in background
    }
    public void handleNavigateToActivity2(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
