package com.example.database2;

import androidx.annotation.NonNull;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DatabaseHandler {

    private static final String TAG = "MainActivity";
    private FirebaseDatabase database;
    private Context currentContext;


    public DatabaseHandler(Context kurmiqnko){
        database = FirebaseDatabase.getInstance("https://vintagefoodslogin-default-rtdb.europe-west1.firebasedatabase.app");
        currentContext = kurmiqnko;
        DatabaseReset a = new DatabaseReset();
    }


    public void basicReadWrite() {
        // [START write_message]
        // Write a message to the database

        DatabaseReference myRef = database.getReference("edno");
        myRef.setValue("tri put kur");
        myRef.child("edno").child("dve").setValue("bvyqb18bv8");
        // [END write_message]

        // [START read_message]
        // Read from the database
        // [END read_message]

        }
    public Map<String,ArrayList<String>> readItems(int lockerId){

        DatabaseReference lockerRef = database.getReference("Lockers").child(Integer.toString(lockerId)).child("Items");
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
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(currentContext, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
        HashMap<String,ArrayList<String>> items = new HashMap<>();
        items.put("images",images);
        items.put("names",names);
        items.put("descriptions",descritions);
        return items;

    }
    public Map<String,ArrayList<String>> readOffers(int lockerId){

        DatabaseReference lockerRef = database.getReference("Offers").child(Integer.toString(lockerId)).child("Items");
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

                    System.out.println("kur");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(currentContext, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
        HashMap<String,ArrayList<String>> offers = new HashMap<>();
        offers.put("availability",images);
        offers.put("name",names);
        offers.put("description",descritions);
        return offers;

    }
    public void uploadItem(String name, String description, String image, String lockerId){
        DatabaseReference itemRef = database.getReference("Lockers").child(lockerId).child("Items").child(name);
        itemRef.child("name").setValue(name);
        itemRef.child("description").setValue(description);
        itemRef.child("image").setValue(image);
    }

    public void uploadOffer(String name, String description, String availability, String lockerId){
        DatabaseReference offerRef = database.getReference("Offers").child(lockerId).child("Items").child(name);
        offerRef.child("name").setValue(name);
        offerRef.child("description").setValue(description);
        offerRef.child("availability").setValue(availability);
    }
    public void removeItem(String name, String lockerId){
        DatabaseReference offerRef = database.getReference("Lockers").child(lockerId).child("Items").child(name);
        offerRef.removeValue();
    }
    public void removeOffer(String name, String lockerId){
        DatabaseReference offerRef = database.getReference("Offers").child(lockerId).child("Items").child(name);
        offerRef.removeValue();
    }
}