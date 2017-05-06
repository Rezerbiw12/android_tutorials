package com.example.hoangnd.androidturotialproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void handleSaveData(View view) {
        Flower newFlower = new Flower("sunflower", "", 10);
        databaseReference.child(newFlower.name).setValue(newFlower);
    }
}
