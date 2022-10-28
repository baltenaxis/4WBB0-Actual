package com.example.database2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionPutOrTake extends AppCompatActivity {

    boolean smthin = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_put_or_take);
        Button takefoodout = findViewById(R.id.takefoodout);
        Button putfoodin = findViewById(R.id.putfoodin);


        takefoodout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add page for bluetooth thing
                //Intent intent = new Intent(OptionPutOrTake.this, Offers.class);
                //startActivity(intent);
                if(smthin) {
                    Popup popUpClass = new Popup("maika ti");
                    popUpClass.showPopupWindow(view);
                }else{
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            OptionPutOrTake.this);


                    // set title
                    alertDialogBuilder.setTitle("Your Title");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Click yes to exit!")
                            .setCancelable(false)
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, close
                                    // current activity
                                    OptionPutOrTake.this.finish();
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
            }
        });

        Button main= findViewById(R.id.button);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mainpage.class);
                startActivity(intent);

            }
        });

        putfoodin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(smthin){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            OptionPutOrTake.this);


                    // set title
                    alertDialogBuilder.setTitle("Your Title");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Click yes to exit!")
                            .setCancelable(false)
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, close
                                    // current activity
                                    OptionPutOrTake.this.finish();
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
                }else {
                    Intent intent2 = new Intent(OptionPutOrTake.this, IntroduceFood.class);
                    startActivity(intent2);
                }
            }
        });
    }
}