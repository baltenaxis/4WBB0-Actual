package com.example.database2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class PreLogOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_log_out);

        Button yes = findViewById(R.id.button1);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Welcome.class);
                HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
                intent.putExtra("kur",hashMap);
                startActivity(intent);

            }
        });

        Button no = findViewById(R.id.button);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mainpage.class);
                HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
                intent.putExtra("kur",hashMap);
                startActivity(intent);

            }
        });
    }
}