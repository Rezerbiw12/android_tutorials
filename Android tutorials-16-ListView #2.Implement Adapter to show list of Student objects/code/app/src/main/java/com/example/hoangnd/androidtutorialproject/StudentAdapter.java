package com.example.hoangnd.androidtutorialproject;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hoangnd.androidtutorialproject.models.Student;
import android.view.LayoutInflater;
import android.content.Context;
import java.util.ArrayList;

import android.widget.TextView;
/**
 * Created by hoangnd on 5/3/17.
 */

class StudentAdapter extends BaseAdapter {
    Activity context;
    ArrayList<Student> students;
    private static LayoutInflater inflater = null;

    public StudentAdapter(Activity context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.list_item, null): itemView;
        TextView textViewName = (TextView) itemView.findViewById(R.id.textViewName);
        TextView textViewEmail = (TextView) itemView.findViewById(R.id.textViewEmail);
        Student selectedStudent = students.get(position);
        textViewName.setText(selectedStudent.name);
        textViewEmail.setText(selectedStudent.email);
        return  itemView;
    }
}
