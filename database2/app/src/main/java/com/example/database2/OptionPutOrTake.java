package com.example.database2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionPutOrTake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_put_or_take);
        Button takefoodout = findViewById(R.id.takefoodout);
        Button putfoodin = findViewById(R.id.putfoodin);


        takefoodout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add page for bluetooth thing
                //Intent intent = new Intent(OptionPutOrTake.this, Offers.class);
                //startActivity(intent);

            }
        });

        putfoodin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(OptionPutOrTake.this, IntroduceFood.class);
                startActivity(intent2);
            }
        });
    }
}