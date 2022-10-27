package com.example.database2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Offers extends AppCompatActivity {
    private ListView list;
    private HashMap<String, ArrayList<String>> hashMap;
    private boolean done=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        readOffers(1);
    }


    public void readOffers(int lockerId) {

        DatabaseReference lockerRef = FirebaseDatabase.getInstance("https://vintagefoodslogin-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("Offers").child(Integer.toString(lockerId)).child("Items");
        ArrayList<String> images = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> descritions = new ArrayList<>();
        lockerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot_a : snapshot.getChildren()) {

                    String availability = snapshot_a.child("availability").getValue(String.class);
                    images.add(availability);
                    String name = snapshot_a.child("name").getValue(String.class);
                    names.add(name);
                    String description = snapshot_a.child("description").getValue(String.class);
                    descritions.add(description);
                    done=true;
                    System.out.println("kurqweq");
                }
                HashMap<String,ArrayList<String>> offers = new HashMap<>();
                offers.put("availability",images);
                offers.put("name",names);
                offers.put("description",descritions);
                hashMap=offers;
                draw();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Offers.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }

        });

    }

    public void draw(){
        ArrayList<String> brat = hashMap.get("name");
        ArrayList<String> brat1 = hashMap.get("description");
        ArrayList<String> brat2 = hashMap.get("availability");

        setContentView(R.layout.activity_offers);

        String[] kur2 = brat.toArray(new String[0]);
        String[] kur4 = brat1.toArray(new String[0]);
        String[] kur6 = new String[1];

        ItemAdapter adapter = new ItemAdapter(this, kur2, kur4, kur6);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        readOffers(1);
        System.out.println("maika ti2");
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if (position == 0) {
                    Popup popUpClass = new Popup();
                    popUpClass.showPopupWindow(view);
                    if(popUpClass.accept) {
                        removeOffer(kur2[0], "1");
                    }
                } else if (position == 1) {
                    Popup popUpClass = new Popup();
                    popUpClass.showPopupWindow(view);
                    if(popUpClass.accept) {
                        removeOffer(kur2[1], "1");
                    }
                } else if (position == 2) {
                    Popup popUpClass = new Popup();
                    popUpClass.showPopupWindow(view);
                    if(popUpClass.accept) {
                        removeOffer(kur2[2], "1");
                    }

                } else if (position == 3) {
                    Popup popUpClass = new Popup();
                    popUpClass.showPopupWindow(view);
                    if(popUpClass.accept) {
                        removeOffer(kur2[3], "1");
                    }


                } else if (position == 4) {
                    Popup popUpClass = new Popup();
                    popUpClass.showPopupWindow(view);
                    if(popUpClass.accept) {
                        removeOffer(kur2[4], "1");
                    }
                }

            }
        });

        ImageButton goback = findViewById(R.id.goBack);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mainpage.class);
                startActivity(intent);
            }
        });

        Button postoffer = findViewById(R.id.buttonpost);
        postoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UploadOffer.class);
                startActivity(intent);
            }
        });

    }
    public void removeOffer(String name, String lockerId){
        DatabaseReference offerRef = FirebaseDatabase.getInstance("https://vintagefoodslogin-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("Offers").child(lockerId).child("Items").child(name);
        offerRef.removeValue();
    }
}