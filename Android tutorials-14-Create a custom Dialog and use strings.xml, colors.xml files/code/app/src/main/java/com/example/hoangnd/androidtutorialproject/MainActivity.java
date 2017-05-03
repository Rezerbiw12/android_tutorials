package com.example.hoangnd.androidtutorialproject;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void handleOpenDialog(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_layout);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "this is Cancel button");
                dialog.dismiss();
            }
        });

        Button btnOk = (Button) dialog.findViewById(R.id.btnOK);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "this is Ok button");
                dialog.dismiss();
            }
        });

        dialog.setTitle("my dialog title");
        dialog.show();
    }
}
