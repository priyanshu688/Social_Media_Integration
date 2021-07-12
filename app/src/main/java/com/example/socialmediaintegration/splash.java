package com.example.socialmediaintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static java.lang.Thread.sleep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends Activity {

    TextView designed, app_name, intern;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.imagesplash);
        designed = findViewById(R.id.designed);
        app_name = findViewById(R.id.app_name);
        intern = findViewById(R.id.intern);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startEnterAnimation();
            }
        }, 1300);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }
        }, 5000);
    }

    private void startEnterAnimation() {

        app_name.startAnimation(AnimationUtils.loadAnimation(splash.this, R.anim.myanimation));
        logo.startAnimation(AnimationUtils.loadAnimation(splash.this, R.anim.myanimation));
        designed.startAnimation(AnimationUtils.loadAnimation(splash.this, R.anim.myanimation));
        intern.startAnimation(AnimationUtils.loadAnimation(splash.this, R.anim.myanimation));

        logo.setVisibility(View.VISIBLE);
        designed.setVisibility(View.VISIBLE);
        app_name.setVisibility(View.VISIBLE);
        intern.setVisibility(View.VISIBLE);
    }
}