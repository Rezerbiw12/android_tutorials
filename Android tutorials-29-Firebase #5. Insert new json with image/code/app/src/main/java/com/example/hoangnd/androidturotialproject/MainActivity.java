package com.example.hoangnd.androidturotialproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private EditText editTextFlowerName;
    private EditText editTextAmount;
    private ImageView imageViewFlower;
    private Button btnInsertData;
    private String imageFileName;

    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFlowerName = (EditText) findViewById(R.id.editTextFlowerName);
        editTextAmount = (EditText) findViewById(R.id.editTextAmount);
        imageViewFlower = (ImageView) findViewById(R.id.imageViewFlower);
        btnInsertData = (Button)findViewById(R.id.btnInsertData);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageRef = storage.getReferenceFromUrl("gs://androidtutorialproject.appspot.com/images");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() == null) {
                    return;
                }
                Map<String, Object> updatedFlower = (Map<String, Object>) dataSnapshot.getValue();
                Log.i("MainActivity", "updatedFlower = "+updatedFlower.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("MainActivity", "onCancelled");
            }
        });

//        storageRef = storage.getReference();

    }
    public void handleInsertData(View view) {
        //validate
        if(TextUtils.isEmpty(editTextFlowerName.getText().toString())) {
            Toast.makeText(this, "Flower name cannot be null !", Toast.LENGTH_SHORT);
            return;
        }
        if(TextUtils.isEmpty(editTextAmount.getText().toString())) {
            Toast.makeText(this, "Flower amount cannot be null !", Toast.LENGTH_SHORT);
            return;
        }
        if(imageViewFlower.getDrawable() == null) {
            //Image is blank
            Toast.makeText(this, "You must select image !", Toast.LENGTH_SHORT);
            return;
        }
        Flower newFlower = new Flower(editTextFlowerName.getText().toString(),
                imageFileName,
                Integer.parseInt(editTextAmount.getText().toString()));
        databaseReference.child(newFlower.name).setValue(newFlower);
        Toast.makeText(MainActivity.this, "Add json and upload image OK !", Toast.LENGTH_SHORT);

    }

    public void handleChooseImage(View view) {
        Intent pickerPhotoIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickerPhotoIntent, 1);
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
                    this.uploadImageToFirebase();
                }
                break;
        }
    }

    private void uploadImageToFirebase() {
        // Get the data from an ImageView as bytes
        this.imageViewFlower.setDrawingCacheEnabled(true);
        this.imageViewFlower.buildDrawingCache();
        Bitmap bitmap = this.imageViewFlower.getDrawingCache();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();
//        StorageReference mountainsRef = storageRef.child("myimagename.jpg");
        this.imageFileName = StringUtility.getRandomString(20) + ".jpg";
        StorageReference flowerRef = storageRef.child(imageFileName);
        Log.i("MainActivity", ""+"image file name = "+imageFileName);

        UploadTask uploadTask = flowerRef.putBytes(data);

        uploadTask.addOnFailureListener(new OnFailureListener() {

            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.i("MainActivity", "Upload failed");
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                Log.i("MainActivity", "Upload successful, downloadUrl = "+downloadUrl);
            }
        });
    }


}
