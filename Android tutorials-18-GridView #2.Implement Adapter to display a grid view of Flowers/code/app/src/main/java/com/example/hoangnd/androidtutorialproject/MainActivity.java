package com.example.hoangnd.androidtutorialproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.hoangnd.androidtutorialproject.models.Flower;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridViewFlowers;
    ArrayList<Flower> flowers = new ArrayList<>();
    FlowerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateGridView();
    }
    private void populateGridView() {
        gridViewFlowers = (GridView) findViewById(R.id.gridViewFlowers);
        flowers.add(new Flower("boom", R.drawable.bloom));
        flowers.add(new Flower("coneflower",R.drawable.coneflower));
        flowers.add(new Flower("lavender",R.drawable.lavender));
        flowers.add(new Flower("rose",R.drawable.rose));
        flowers.add(new Flower("smaryllis",R.drawable.smaryllis));
        flowers.add(new Flower("sunflower",R.drawable.sunflower));
        flowers.add(new Flower("tulip",R.drawable.tulip));
        flowers.add(new Flower("windflower",R.drawable.windflower));
        adapter = new FlowerAdapter(this, flowers);
        gridViewFlowers.setAdapter(adapter);
        gridViewFlowers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click to item: "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
