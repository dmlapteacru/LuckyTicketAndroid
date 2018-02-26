package com.example.ahitler_fcked_my_dog.myapplication;

import android.app.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MainActivity extends Activity {
    Thread t;
    int countD = 4;
    private View lay;
    Animation animFadein;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // load the animation
                animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation_file);
        //lay = findViewById(R.id.layout_6);
        lay.setAnimation(animFadein);


    }

}
