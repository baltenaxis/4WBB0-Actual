package com.example.database2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;


public class UploadOffer extends AppCompatActivity {

    EditText mfname, mfdescription, mfdate;
    Button upload_button;

    FirebaseFirestore fstore;
    String offer_id;

    Offer moffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_offer);

        mfname=findViewById(R.id.foodname);
        mfdescription=findViewById(R.id.description);
        mfdate=findViewById(R.id.time);
        upload_button=findViewById(R.id.buttonupload);

        fstore=FirebaseFirestore.getInstance();

        moffer=new Offer();

        upload_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String food_name = mfname.getText().toString();
                String food_description = mfdescription.getText().toString();
                String food_availability = mfdate.getText().toString();

                // below line is for checking whether the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(food_name) && TextUtils.isEmpty(food_description) && TextUtils.isEmpty(food_availability)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(UploadOffer.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    //TODO
                    addDatatoFirebase(name, phone, address);
                }
            }
        });


        ImageButton goback2=findViewById(R.id.goBack2);
        goback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadOffer.this, Offers.class);
                startActivity(intent);
            }
        });
    }
}

