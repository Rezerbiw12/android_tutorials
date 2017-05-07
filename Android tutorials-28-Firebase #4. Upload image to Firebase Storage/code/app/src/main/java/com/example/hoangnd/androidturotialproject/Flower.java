package com.example.hoangnd.androidturotialproject;

/**
 * Created by hoangnd on 5/6/17.
 */

public class Flower {
    public String name;
    public String imageLink;
    public int amount;

    public Flower(String name, String imageLink, int amount) {
        this.name = name;
        this.imageLink = imageLink;
        this.amount = amount;
    }
    public Flower() {
        name = "";
        imageLink = "";
        amount = 0;
    }
}
