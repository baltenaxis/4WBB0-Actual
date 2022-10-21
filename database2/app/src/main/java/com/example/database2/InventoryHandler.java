package com.example.database2;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InventoryHandler extends AppCompatActivity {
    ListView Inventory;
    String[] data;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        final ArrayList<Item> arrayList = new ArrayList<Item>();

        arrayList.add(new Item(R.drawable.abcd, "1", "One"));
        arrayList.add(new Item(R.drawable.abcd, "2", "Two"));
        arrayList.add(new Item(R.drawable.abcd, "3", "Three"));
        arrayList.add(new Item(R.drawable.abcd, "4", "Four"));
        arrayList.add(new Item(R.drawable.abcd, "5", "Five"));
        arrayList.add(new Item(R.drawable.abcd, "6", "Six"));
        arrayList.add(new Item(R.drawable.abcd, "7", "Seven"));
        arrayList.add(new Item(R.drawable.abcd, "8", "Eight"));
        arrayList.add(new Item(R.drawable.abcd, "9", "Nine"));
        arrayList.add(new Item(R.drawable.abcd, "10", "Ten"));
        arrayList.add(new Item(R.drawable.abcd, "11", "Eleven"));
        arrayList.add(new Item(R.drawable.abcd, "12", "Twelve"));
        arrayList.add(new Item(R.drawable.abcd, "13", "Thirteen"));
        arrayList.add(new Item(R.drawable.abcd, "14", "Fourteen"));
        arrayList.add(new Item(R.drawable.abcd, "15", "Fifteen"));


        ItemAdapter itemArrayAdapter = new ItemAdapter(this, arrayList);
        ListView itemListView = findViewById(R.layout.custom_list_view);

        itemListView.setAdapter(itemArrayAdapter);

    }
}
