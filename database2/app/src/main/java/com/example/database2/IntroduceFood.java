package com.example.database2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IntroduceFood extends AppCompatActivity {


    CheckBox mCheckbVeg, mCheckbFruit, mCheckbSnacks, mCheckbCooked, mCheckbOther;
    EditText mFoodName;
    EditText mExpirationDate;
    Button mIdSelectPhoto;
    Button mConfirmButton;
    ImageButton mGoBack;
    TextView mTextTandCBtn;
    TextView mFoodCategory;
    ImageView mIVPreviewImage;


    int SELECT_PICTURE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_food);
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
        mGoBack = findViewById(R.id.goBack3);


        // handle the Choose Image button to trigger
        // the image chooser function
        mIdSelectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        mGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OptionPutOrTake.class);
                startActivity(intent);
            }
        });
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        IntroduceFood.this);


                // set title
                alertDialogBuilder.setTitle("Are you sure?");

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

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

                                Intent intent = new Intent(getApplicationContext(), Mainpage.class);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();




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
    public void uploadItem(String name, String description, String image, String lockerId){
        DatabaseReference itemRef = FirebaseDatabase.getInstance("https://vintagefoodslogin-default-rtdb.europe-west1.firebasedatabase.app").getReference("Lockers").child(lockerId).child("Items").child(name);
        itemRef.child("name").setValue(name);
        itemRef.child("description").setValue(description);
        itemRef.child("image").setValue(image);
    }





}





