package com.example.hoangnd.androidtutorialproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    public void handleNavigateToScreen2(View view) {
//        Toast.makeText(FirstActivity.this, "click to Navigate", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra("name", "Nguyen Duc Hoang");
        intent.putExtra("email", "sunlight4d@gmail.com");
        startActivity(intent);
    }
}
