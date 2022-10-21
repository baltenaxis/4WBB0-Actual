package com.example.database2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

<<<<<<< Updated upstream
    private static int SPLASH_SCREEN = 2000;
    //Variable
    Animation bottomAnim;
    ImageView image;


=======
    Animation bottomAnim;
    ImageView image;
    
>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Animations
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

<<<<<<< Updated upstream
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        bottomAnim= AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        image = findViewById(R.id.imageView5);
=======
        //Hooks
        image=findViewById(R.id.imageView4);
>>>>>>> Stashed changes
        image.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Welcome.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }

}