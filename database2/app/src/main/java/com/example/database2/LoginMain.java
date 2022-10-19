package com.example.database2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class LoginMain extends AppCompatActivity {

    TextView mhelloworld;
    Button mLogOutBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        mhelloworld = findViewById(R.id.helloWorld);
        mLogOutBtn = findViewById(R.id.logOutBtn);
        fAuth = FirebaseAuth.getInstance();
        mhelloworld.setText("blabla");

        mLogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fAuth.signOut();
                Intent intent=(new Intent(getApplicationContext(), Welcome.class));
                startActivity(intent);

                //startActivity(new Intent(getApplicationContext(), Welcome.class));
            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.setting:
//                break;
//
//            case R.id.logout:
//                auth.signOut();
//                Intent intent=new Intent(HomePage.this,Login_Page.class);
//                startActivity(intent);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}