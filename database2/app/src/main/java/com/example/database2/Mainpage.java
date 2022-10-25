package com.example.database2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Mainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button seeoffers = findViewById(R.id.seeoffers);
        seeoffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Offers.class);
                HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
                HashMap<String, ArrayList<String>> hashMap1 = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur1");
                intent.putExtra("kur",hashMap);
                intent.putExtra("kur1",hashMap1);
                startActivity(intent);

            }
        });
        
        Button scanlocker = findViewById(R.id.button2);
        scanlocker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QRHandler.class);
                HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
                HashMap<String, ArrayList<String>> hashMap1 = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur1");
                intent.putExtra("kur",hashMap);
                intent.putExtra("kur1",hashMap1);
                startActivity(intent);
            }
        });

        Button logout= findViewById(R.id.button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PreLogOut.class);
                HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
                HashMap<String, ArrayList<String>> hashMap1 = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur1");
                intent.putExtra("kur",hashMap);
                intent.putExtra("kur1",hashMap1);
                startActivity(intent);

            }
        });
    }
}

