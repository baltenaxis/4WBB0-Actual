package com.example.database2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Mainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button seeoffers = findViewById(R.id.seeoffers);
        seeoffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainpage.this, Offers.class);
                startActivity(intent);

            }
        });
        
        Button scanlocker = findViewById(R.id.button2);
        scanlocker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Mainpage.this, QRHandler.class);
                startActivity(intent2);
            }
        });

        Button logout= findViewById(R.id.button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Mainpage.this, PreLogOut.class);
                startActivity(intent2);

            }
        });
    }
}

