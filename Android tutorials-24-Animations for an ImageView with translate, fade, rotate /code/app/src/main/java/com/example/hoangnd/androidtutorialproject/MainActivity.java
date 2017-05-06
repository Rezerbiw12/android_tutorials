package com.example.hoangnd.androidtutorialproject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    long animationDuration = 1000;//miliseconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    public void handleAnimation(View view) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(imageView,"x", 420f);
        animatorX.setDuration(animationDuration);

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView,"y", 300f);
        animatorY.setDuration(animationDuration);

        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(imageView, View.ALPHA, 1.0f, 0.0f);
        alphaAnimation.setDuration(animationDuration);

        ObjectAnimator rotateAnimation = ObjectAnimator.ofFloat(imageView , "rotation", 0f, 360f);
        rotateAnimation.setDuration(animationDuration);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorX, animatorY);
        animatorSet.start();
    }
}
