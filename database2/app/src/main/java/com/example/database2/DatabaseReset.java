package com.example.database2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseReset {
    public DatabaseReset(){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://vintagefoodslogin-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference lockerRef = database.getReference("Lockers").child(Integer.toString(1)).child("Items");
        lockerRef.child("Baklava").child("Image").setValue("cHyR8Pa.jpg");
        lockerRef.child("Baklava").child("Name").setValue("jiawswr2342342342342tgwergnuwn");
        lockerRef.child("Baklava").child("Description").setValue("qwuiegh90uqw9rewguhqu98");
        lockerRef.child("Bak1lava").child("Image").setValue("cHyR8Pa.jpg");
        lockerRef.child("Bak1lava").child("Name").setValue("jiawrgnuwn");
        lockerRef.child("Bak1lava").child("Description").setValue("jdsbviw jd 234234234234");
        DatabaseReference offerRef = database.getReference("Offers").child(Integer.toString(1)).child("Items");
        offerRef.child("Baklava").child("availability").setValue("Now");
        offerRef.child("Baklava").child("name").setValue("Baklava");
        offerRef.child("Baklava").child("description").setValue("Very tasty baklava for your enjoyment");
        offerRef.child("Lasagna").child("availability").setValue("1 hour");
        offerRef.child("Lasagna").child("name").setValue("Lasagna");
        offerRef.child("Lasagna").child("description").setValue("Lasagna for you sad soul");
        offerRef.child("Sarmale").child("availability").setValue("3 hour");
        offerRef.child("Sarmale").child("name").setValue("Sarmale");
        offerRef.child("Sarmale").child("description").setValue("Be bamboozled by this traditional Balkan dish");
        System.out.println("Resetted");
    }
}
