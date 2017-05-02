package com.example.hoangnd.androidtutorialproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewMultiply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber1 = (EditText) findViewById(R.id.editTextNumber1);
        editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        textViewMultiply = (TextView) findViewById(R.id.textViewMultiply);
    }

    public void handleMultiply(View view) {
        Log.i(TAG, "press multiply");
        if(editTextNumber1.getText().toString().equals("") || editTextNumber2.getText().toString().equals("")) {
            Log.e(TAG, "x, y cannot be NULL");
            return;
        }
        int multiply = Integer.parseInt(editTextNumber1.getText().toString()) * Integer.parseInt(editTextNumber2.getText().toString());
        textViewMultiply.setText(Integer.toString(multiply));
    }
}
