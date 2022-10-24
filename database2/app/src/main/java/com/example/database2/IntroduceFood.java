package com.example.database2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IntroduceFood extends AppCompatActivity {


    CheckBox mCheckbVeg, mCheckbFruit, mCheckbSnacks, mCheckbCooked, mCheckbOther;
    EditText mFoodName;
    EditText mExpirationDate;
    Button mIdSelectPhoto;
    Button mConfirmButton;
    TextView mTextTandCBtn;
    TextView mFoodCategory;
    ImageView mIVPreviewImage;


    int SELECT_PICTURE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFoodCategory = findViewById(R.id.foodCategory);
        mCheckbVeg = findViewById(R.id.checkbVeg);
        mCheckbFruit = findViewById(R.id.checkbFruit);
        mCheckbSnacks = findViewById(R.id.checkbSnacks);
        mCheckbCooked = findViewById(R.id.checkbCooked);
        mCheckbOther = findViewById(R.id.checkbOther);
        mFoodName = findViewById(R.id.foodName);
        mExpirationDate = findViewById(R.id.expirationDate);
        mIdSelectPhoto = findViewById(R.id.idSelectPhoto);
        mConfirmButton = findViewById(R.id.confirmBtn);
        mTextTandCBtn = findViewById(R.id.textTandCBtn);
        mIVPreviewImage = findViewById(R.id.IVPreviewImage);


        // handle the Choose Image button to trigger
        // the image chooser function
        mIdSelectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String foodName = mFoodName.getText().toString().trim();
                final String expirationDate = mExpirationDate.getText().toString().trim();

                if ((TextUtils.isEmpty(foodName))) {
                    mFoodName.setError("Name of product must be addressed");
                    return;
                }
                if ((TextUtils.isEmpty(expirationDate))) {
                    mExpirationDate.setError("Expiration date must be addressed");
                    return;
                }
                if ( !(mCheckbVeg.isChecked() || mCheckbFruit.isChecked() || mCheckbSnacks.isChecked() || mCheckbCooked.isChecked() || mCheckbOther.isChecked())) {
                    mFoodCategory.setError("");
                    Toast.makeText(getApplicationContext(), "Food category must be checked", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mIVPreviewImage.getDrawable() == null) {
                    Toast.makeText(getApplicationContext(), "Photo of product is required", Toast.LENGTH_SHORT).show();
                    return;
                }


            }
        });

        mTextTandCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FoodSafetyRegulation.class));
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





