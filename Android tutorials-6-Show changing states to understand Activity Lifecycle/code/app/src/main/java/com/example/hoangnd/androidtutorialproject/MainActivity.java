package com.example.hoangnd.androidtutorialproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Call onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Call onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Call onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Call onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Call onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Call onDestroy");
    }
}
