package com.example.database2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

public class InventoryHandler extends AppCompatActivity {
    private HashMap<String, ArrayList<String>> hashMap;
    ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        readItems(1);

        }
    public void readItems(int lockerId){

        DatabaseReference lockerRef =FirebaseDatabase.getInstance("https://vintagefoodslogin-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("Lockers").child(Integer.toString(1)).child("Items");
        ArrayList<String> images = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> descritions = new ArrayList<>();
        lockerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot_a : snapshot.getChildren()) {

                    String Image = snapshot_a.child("Image").getValue(String.class);
                    images.add(Image);
                    String Name = snapshot_a.child("Name").getValue(String.class);
                    names.add(Name);
                    String Description = snapshot_a.child("Description").getValue(String.class);
                    descritions.add(Description);

                    System.out.println("kur");
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
                Toast.makeText(InventoryHandler.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void draw(){
        ArrayList<String> brat = hashMap.get("names");
        ArrayList<String> brat1 = hashMap.get("descriptions");
        ArrayList<String> brat2 = hashMap.get("images");


        setContentView(R.layout.activity_inventory);

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
                    //code specific to first list item
                    Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
