package com.example.hoangnd.androidtutorialproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoangnd.androidtutorialproject.models.Flower;

import java.util.ArrayList;

/**
 * Created by hoangnd on 5/4/17.
 */

public class FlowerAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Flower> flowers;
    private static LayoutInflater inflater = null;

    public FlowerAdapter(Context context, ArrayList<Flower> flowers) {
        this.context = context;
        this.flowers = flowers;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return flowers.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Flower getItem(int position) {
        return flowers.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.grid_item, null): itemView;
        ImageView imageViewFlower = (ImageView) itemView.findViewById(R.id.imageViewFlower);
        TextView textViewFlowerName = (TextView) itemView.findViewById(R.id.textViewFlowerName);
        Flower selectedFlower = flowers.get(position);
        imageViewFlower.setImageResource(selectedFlower.imageId);
        textViewFlowerName.setText(selectedFlower.name);
        return itemView;
    }
}
