package com.example.hoangnd.androidtutorialproject;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.setImageResource(R.drawable.animation_image);
    }
    public void handleAnimation(View view) {

        ObjectAnimator animX = ObjectAnimator.ofFloat(imageView, "x", 420f);
        //Default is 300ms
        long duration = 1000;
        animX.setDuration(duration);
//        ObjectAnimator animY = ObjectAnimator.ofFloat(imageView, "y", 0f);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(imageView, View.ALPHA, 1.0f, 0.0f);

        ObjectAnimator rotateAnimation = ObjectAnimator.ofFloat(imageView ,
                "rotation", 0f, 360f);
        rotateAnimation.setDuration(duration);

        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.playTogether(animX, rotateAnimation);
        animSetXY.start();
    }
}
