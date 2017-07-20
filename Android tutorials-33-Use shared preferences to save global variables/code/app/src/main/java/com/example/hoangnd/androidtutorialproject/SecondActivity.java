package com.example.hoangnd.androidtutorialproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void handleReadGlobalVariables(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.globalPreferenceName, MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "No name");//"No name" = default value.
        String email = sharedPreferences.getString("email", "No email");//"email" = default value.
        String address = sharedPreferences.getString("address", "No address found");//"email" = default value.
        int age = sharedPreferences.getInt("age", 18); //18 = default value.
        Toast.makeText(this, "Name = "+name+" Email = "+email+" Age = "+age+" Address = "+address, Toast.LENGTH_LONG).show();
    }
}
