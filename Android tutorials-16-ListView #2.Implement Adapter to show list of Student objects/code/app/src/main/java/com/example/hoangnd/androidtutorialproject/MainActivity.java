package com.example.hoangnd.androidtutorialproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hoangnd.androidtutorialproject.models.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewStudents;
    private ArrayList<Student> students = new ArrayList<>();
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListView();
    }

    public void populateListView() {
        listViewStudents = (ListView) findViewById(R.id.listViewStudents);
        students.add(new Student("Tom Hanks", "mail222@gmail.com",""));
        students.add(new Student("Babbie Nim", "mail333@gmail.com",""));
        students.add(new Student("Alex Nguyen", "mail444@gmail.com",""));
        students.add(new Student("John Lasseter", "mail111@gmail.com",""));
        students.add(new Student("Domino Roro", "mail555@gmail.com",""));
        students.add(new Student("Moon Kat ", "mail666@gmail.com",""));
        students.add(new Student("Kitty Toys ", "mail777@gmail.com",""));
        adapter = new StudentAdapter(this, students);
        listViewStudents.setAdapter(adapter);
        listViewStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click to item: "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
