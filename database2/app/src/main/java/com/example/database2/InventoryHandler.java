package com.example.database2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class InventoryHandler extends AppCompatActivity {
    ListView Inventory;
    String[] data;

    protected void onCreate(Bundle savedInstanceState) {
        ListView list;

        DatabaseHandler a = new DatabaseHandler(getApplicationContext());
        HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
        ArrayList<String> brat = hashMap.get("names");
        ArrayList<String> brat1 = hashMap.get("descriptions");
        ArrayList<String> brat2 = hashMap.get("images");

        super.onCreate(savedInstanceState);
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
