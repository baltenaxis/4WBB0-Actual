package com.example.database2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;


public class UploadOffer extends AppCompatActivity {

    EditText mfname, mfdescription, mfdate;
    Button upload_button;
    ImageView mIVPreviewImage;

    Button mpostoffer;
    FirebaseFirestore fstore;
    String offer_id;
    Offer moffer;

    int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_offer);

        mfname=findViewById(R.id.foodname);
        mfdescription=findViewById(R.id.description);
        mfdate=findViewById(R.id.time);
        upload_button=findViewById(R.id.button4);
        mIVPreviewImage = findViewById(R.id.IVPreviewImage);
        mpostoffer = findViewById(R.id.postpic);

        fstore=FirebaseFirestore.getInstance();

        moffer=new Offer();


        // handle the Choose Image button to trigger
        // the image chooser function
        upload_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });



        mpostoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler a = new DatabaseHandler(getApplicationContext());
                // getting text from our edittext fields.
                String food_name = mfname.getText().toString();
                String food_description = mfdescription.getText().toString();
                String food_availability = mfdate.getText().toString();

                // below line is for checking whether the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(food_name) && TextUtils.isEmpty(food_description) && TextUtils.isEmpty(food_availability) && (mIVPreviewImage.getDrawable() == null) ) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(UploadOffer.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    a.uploadOffer(food_name,food_description,food_availability,"1");
                }
            }
        });


        ImageButton goback2=findViewById(R.id.goBack2);
        goback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Offers.class);
                HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("kur");
                intent.putExtra("kur",hashMap);
                startActivity(intent);
            }
        });
    }



    // this function is triggered when
    // the Select Image Button is clicked
    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    mIVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }

}

