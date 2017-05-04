package com.example.hoangnd.androidtutorialproject;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBarPercent;
    private TextView textViewPercent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBarPercent = (SeekBar) findViewById(R.id.seekBarPercent);
        textViewPercent = (TextView) findViewById(R.id.textViewPercent);

        seekBarPercent.getProgressDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
        seekBarPercent.getThumb().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);

        seekBarPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewPercent.setText("Progress: " + progress + "/" + seekBarPercent.getMax() + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Start...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                textViewPercent.setText("Progress: " + progress + seekBarPercent.getMax() + " %");
                Toast.makeText(MainActivity.this, "Stop...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
