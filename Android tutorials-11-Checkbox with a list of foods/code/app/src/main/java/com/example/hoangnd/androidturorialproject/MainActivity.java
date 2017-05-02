package com.example.hoangnd.androidturorialproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBoxPizza;
    private CheckBox checkBoxSalad;
    private CheckBox checkBoxCake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxPizza = (CheckBox) findViewById(R.id.checkBoxPizza);
        checkBoxSalad = (CheckBox) findViewById(R.id.checkBoxSalad);
        checkBoxCake = (CheckBox) findViewById(R.id.checkBoxCake);

        checkBoxPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox myCheckbox = (CheckBox)v;
                if(myCheckbox.isChecked()) {
                    Toast.makeText(MainActivity.this, "Pizza is checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Pizza is unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox myCheckbox = (CheckBox)v;
                if(myCheckbox.isChecked()) {
                    Toast.makeText(MainActivity.this, "Salad is checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Salad is unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox myCheckbox = (CheckBox)v;
                if(myCheckbox.isChecked()) {
                    Toast.makeText(MainActivity.this, "Cake is checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Cake is unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
