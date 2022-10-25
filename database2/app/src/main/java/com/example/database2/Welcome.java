package com.example.database2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class Welcome extends AppCompatActivity {

    Button mLoginPageBtn;
    Button mRegisterPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mLoginPageBtn = findViewById(R.id.loginPageBtn);
        mRegisterPageBtn = findViewById(R.id.registerPageBtn);

        mRegisterPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
                HashMap<String, ArrayList<String>> hashMap1 = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur1");
                intent.putExtra("kur",hashMap);
                intent.putExtra("kur1",hashMap1);
                startActivity(intent);
            }
        });

        mLoginPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
                HashMap<String, ArrayList<String>> hashMap1 = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur1");
                intent.putExtra("kur",hashMap);
                intent.putExtra("kur1",hashMap1);
                startActivity(intent);
            }
        });


    }
}