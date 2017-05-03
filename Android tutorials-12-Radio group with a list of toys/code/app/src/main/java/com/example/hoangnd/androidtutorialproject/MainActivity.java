package com.example.hoangnd.androidtutorialproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton radioIronMan;
    private RadioButton radioFrozenQueen;
    private RadioButton radioSpiderMan;
    private RadioGroup radioGroupToys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioIronMan = (RadioButton) findViewById(R.id.radioIronMan);
        radioFrozenQueen = (RadioButton)findViewById(R.id.radioFrozenQueen);
        radioSpiderMan = (RadioButton)findViewById(R.id.radioSpiderMan);
        radioGroupToys = (RadioGroup) findViewById(R.id.radioGroupToys);

    }
    public void onRadioButtonClicked(View view) {
//        Toast.makeText(this, "clicked to radio button", Toast.LENGTH_LONG).show();
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioIronMan:
                if(checked) {
                    Toast.makeText(this, "Iron Man is checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.radioFrozenQueen:
                if(checked) {
                    Toast.makeText(this, "Frozen Queen is checked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.radioSpiderMan:
                if(checked) {
                    Toast.makeText(this, "Spider Man is checked", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
