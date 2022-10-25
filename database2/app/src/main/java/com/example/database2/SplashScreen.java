package com.example.database2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2000;
    //Variable
    Animation bottomAnim;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        bottomAnim= AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        image = findViewById(R.id.imageView5);
        image.setAnimation(bottomAnim);
        DatabaseHandler a = new DatabaseHandler(getApplicationContext());
        HashMap<String,ArrayList<String>> items1 = (HashMap<String, ArrayList<String>>) a.readItems(1);
        HashMap<String,ArrayList<String>> items2 = (HashMap<String, ArrayList<String>>) a.readOffers(1);
        /*ArrayList<Item> items2 = a.readItems(2);
        ArrayList<Item> items3 = a.readItems(3);*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Welcome.class);
                intent.putExtra("kur",items1);
                intent.putExtra("kur1",items2);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }

}