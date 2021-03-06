package com.example.hoangnd.androidturotialproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private EditText editTextFlowerName;
    private EditText editTextAmount;
    private ImageView imageViewFlower;
    private Button btnInsertData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFlowerName = (EditText) findViewById(R.id.editTextFlowerName);
        editTextAmount = (EditText) findViewById(R.id.editTextAmount);
        imageViewFlower = (ImageView) findViewById(R.id.imageViewFlower);
        btnInsertData = (Button)findViewById(R.id.btnInsertData);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> updatedFlower = (Map<String, Object>) dataSnapshot.getValue();
                Log.i("MainActivity", "updatedFlower = "+updatedFlower.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("MainActivity", "onCancelled");
            }
        });
    }
    public void handleChooseImage(View view) {
        Intent pickerPhotoIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickerPhotoIntent, 1);
    }

    public void handleInsertData(View view) {
        if(editTextFlowerName.getText().toString() == "") {
            Toast.makeText(this, "Flower name cannot be null !", Toast.LENGTH_SHORT);
            return;
        }
        if(editTextAmount.getText().toString() == "") {
            Toast.makeText(this, "Flower's amount cannot be null !", Toast.LENGTH_SHORT);
            return;
        }
        if( this.imageViewFlower.getDrawable() == null) {
            //Image is blank
            Toast.makeText(this, "You must select image !", Toast.LENGTH_SHORT);
            return;
        }
        //Insert data to Firebase Storage
        

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case 0:
                if(requestCode == RESULT_OK) {
                    Log.i("MainActivity", "case 0");
                }
                break;
            case 1:
                if(resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    Log.i("MainActivity", "selected Image = "+selectedImage);
                    this.imageViewFlower.setImageURI(selectedImage);
                }
                break;
        }
    }
}
