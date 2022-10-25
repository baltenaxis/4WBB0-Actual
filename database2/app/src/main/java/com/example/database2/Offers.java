package com.example.database2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;


public class Offers extends AppCompatActivity {
    private DatabaseHandler a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView list;

        a = new DatabaseHandler(getApplicationContext());
        HashMap<String, ArrayList<String>> hashMap;
        if(a.readOffers(1).get("name").isEmpty()) {
            hashMap = (HashMap<String, ArrayList<String>>) getIntent().getSerializableExtra("kur1");
        }else{
            hashMap=(HashMap<String, ArrayList<String>>) a.readOffers(1);
        }
        ArrayList<String> brat = hashMap.get("name");
        ArrayList<String> brat1 = hashMap.get("description");
        ArrayList<String> brat2 = hashMap.get("availability");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        String[] kur2 = brat.toArray(new String[0]);
        String[] kur4 = brat1.toArray(new String[0]);
        String[] kur6 = new String[1];

        ItemAdapter adapter=new ItemAdapter(this, kur2, kur4, kur6);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        System.out.println("maika ti2");
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    Popup popUpClass = new Popup(a);
                    popUpClass.showPopupWindow(view);
                }

                else if(position == 1) {
                    Popup popUpClass = new Popup(a);
                    popUpClass.showPopupWindow(view);
                }

                else if(position == 2) {

                }
                else if(position == 3) {


                }
                else if(position == 4) {


                }

            }
        });

        ImageButton goback=findViewById(R.id.goBack);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mainpage.class);
                HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
                HashMap<String, ArrayList<String>> hashMap1 = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur1");
                intent.putExtra("kur",hashMap);
                intent.putExtra("kur1",hashMap1);
                startActivity(intent);
            }
        });

        Button postoffer = findViewById(R.id.buttonpost);
        postoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UploadOffer.class);
                HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
                HashMap<String, ArrayList<String>> hashMap1 = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur1");
                intent.putExtra("kur",hashMap);
                intent.putExtra("kur1",hashMap1);
                startActivity(intent);
            }
        });



    }
}