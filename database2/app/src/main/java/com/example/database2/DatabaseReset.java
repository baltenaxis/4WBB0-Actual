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
        offerRef.child("Baklava").child("availability").setValue("cHyR8Pa.jpg");
        offerRef.child("Baklava").child("name").setValue("jiawswr2342342342342tgwergnuwn");
        offerRef.child("Baklava").child("description").setValue("qwuiegh90uqw9rewguhqu98");
        offerRef.child("Bak1lava").child("availability").setValue("cHyR8Pa.jpg");
        offerRef.child("Bak1lava").child("name").setValue("jiawrgnuwn");
        offerRef.child("Bak1lava").child("description").setValue("jdsbviw jd 234234234234");
        System.out.println("Resetted");
    }
}
