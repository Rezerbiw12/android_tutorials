package com.example.hoangnd.androidtutorialproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String nameFromFirstScreen = getIntent().getStringExtra("name");
        String emailFromFirstScreen = getIntent().getStringExtra("email");
        Toast.makeText(SecondActivity.this,
                "Data from First Screen: "+nameFromFirstScreen +"email: "+emailFromFirstScreen
                ,Toast.LENGTH_LONG).show();
    }
}
