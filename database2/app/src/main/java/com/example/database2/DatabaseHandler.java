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
import java.util.Random;

public class DatabaseHandler {

    private static final String TAG = "MainActivity";
    private FirebaseDatabase database;
    private Context currentContext;


    public DatabaseHandler(Context kurmiqnko){
        database = FirebaseDatabase.getInstance("https://vintagefoodslogin-default-rtdb.europe-west1.firebasedatabase.app");
        currentContext = kurmiqnko;
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
    public ArrayList<Item> readItems(int lockerId){

        DatabaseReference lockerRef = database.getReference("Lockers").child(Integer.toString(lockerId)).child("Items");
        Random xd = new Random();
        lockerRef.child("Random").setValue(xd.nextInt());
        lockerRef.child("Baklava").child("Image").setValue("wiejti");
        lockerRef.child("Baklava").child("Name").setValue("jiawrgnuwn");
        lockerRef.child("Baklava").child("Description").setValue("jdsbviw jd vwhbgrjjqnwdjvbweu");
        lockerRef.child("Bak1lava").child("Image").setValue("wiejti");
        lockerRef.child("Bak1lava").child("Name").setValue("jiawrgnuwn");
        lockerRef.child("Bak1lava").child("Description").setValue("jdsbviw jd vwhbg12423rrjjqnwdjvbweu");

        ArrayList<Item> items = new ArrayList<>();
        lockerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot_a : snapshot.getChildren()) {

                    String Image = snapshot_a.child("Image").getValue(String.class);
                    String Name = snapshot_a.child("Name").getValue(String.class);
                    String Description = snapshot_a.child("Description").getValue(String.class);
                    Item a = new Item(Integer.parseInt(Image), Name, Description);
                    items.add(a);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(currentContext, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
        lockerRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(currentContext, task.getException().toString(), Toast.LENGTH_SHORT).show();
                }
                else {
                    DataSnapshot snapshot = task.getResult();
                    for (DataSnapshot snapshot_a : snapshot.getChildren()) {

                        String Image = snapshot_a.child("Image").getValue(String.class);
                        String Name = snapshot_a.child("Name").getValue(String.class);
                        String Description = snapshot_a.child("Description").getValue(String.class);
                        Item a = new Item(Integer.parseInt(Image), Name, Description);
                        items.add(a);
                    }
                }
            }
        });
        return items;
    }
}