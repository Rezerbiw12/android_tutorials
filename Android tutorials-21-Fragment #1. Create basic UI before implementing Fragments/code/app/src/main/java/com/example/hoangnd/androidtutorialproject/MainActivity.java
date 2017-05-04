package com.example.hoangnd.androidtutorialproject;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import layout.FirstFragment;
import layout.SecondFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void handleChangeFragment(View view) {
        Fragment selectedFragment;
        if(view == findViewById(R.id.btnFragment1)) {
            selectedFragment = new FirstFragment();
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, selectedFragment);
            fragmentTransaction.commit();
        } else if(view == findViewById(R.id.btnFragment2)) {
            selectedFragment = new SecondFragment();
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, selectedFragment);
            fragmentTransaction.commit();
        }

    }
}
