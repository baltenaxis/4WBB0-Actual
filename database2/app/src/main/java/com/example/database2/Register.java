package com.example.database2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText mFullName, mEmail, mPassword, mConfirmPassword;
    Button mRegister;
    TextView mLoginBtn;
    ProgressBar progressBar;

    FirebaseFirestore fstore;
    String userID;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mConfirmPassword = findViewById(R.id.confirmPassword);
        mRegister = findViewById(R.id.registerBtn);
        mLoginBtn = findViewById(R.id.createtext);
        progressBar = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        ImageButton gobacktowelcome=findViewById(R.id.goBackWelcome);
        gobacktowelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentgoback = new Intent(Register.this, Welcome.class);
                startActivity(intentgoback);
            }
        });

        //show hide password
        ImageView imageViewShowHidePsw = findViewById(R.id.imageView_show_hide_psw);
        imageViewShowHidePsw.setImageResource(R.drawable.hide_password_logo);
        imageViewShowHidePsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    // if password is visible hide it
                    mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //change icon
                    imageViewShowHidePsw.setImageResource(R.drawable.hide_password_logo);

                } else {
                    mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageViewShowHidePsw.setImageResource(R.drawable.show_password_logo);

                }
            }
        });

        //show hide confirm password
        ImageView imageViewShowHideConfPsw = findViewById(R.id.imageView_show_hide_conf_psw);
        imageViewShowHideConfPsw.setImageResource(R.drawable.hide_password_logo);
        imageViewShowHideConfPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mConfirmPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    // if password is visible hide it
                    mConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //change icon
                    imageViewShowHideConfPsw.setImageResource(R.drawable.hide_password_logo);

                } else {
                    mConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageViewShowHideConfPsw.setImageResource(R.drawable.show_password_logo);

                }
            }
        });

       //TODO
       /* if (fAuth.getCurrentUser() != null && fAuth.getCurrentUser().isEmailVerified()) {
            mLoginBtn.setText(fAuth.getCurrentUser().getDisplayName());
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        } */

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                final String fullName = mFullName.getText().toString();
                String confirmPassword = mConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email) || !(Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
                    mEmail.setError("A valid email is required");
                    return;
                }

                //if(password.toString().length()<8 &&!isValidPassword(password.toString())){


                if (!isValidPassword(password.toString())){
                    mPassword.setError("Must contain at least: \n - 8 characters \n - 1 number \n - 1 capital letter \n - 1 special character");
                    return;
                }

                if (password.toString().length()<8 ){
                    mPassword.setError("Must contain at least: \n - 8 characters \n - 1 number \n - 1 capital letter \n - 1 special character");
                    return;
                }

                if(!confirmPassword.toString().equals(password.toString()))  {
                    mConfirmPassword.setError("Must match the previous entry");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser fuser = fAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d("yo", "registered ");
                                        Toast.makeText(getApplicationContext(), "Registered successfully. Please check your email for verification", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }

//                            @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()) {
//                                        Log.d("yo", "registered ");
//                                        Toast.makeText(getApplicationContext(), "Registered successfully. Please check your email for verification", Toast.LENGTH_LONG).show();
//                                    } else {
//                                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                                    }
//                                }
                                //fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                //   @Override
                                // public void onSuccess(Void unused) {

                                // }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "OnFailure: Email not sent" + e.getMessage());
                                }
                            });

                            //Toast.makeText(getApplicationContext(), "User created", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("user").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName", fullName);
                            user.put("email", email);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG, "onSuccess: User profile is created for" + userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });

                            startActivity(new Intent(getApplicationContext(), Welcome.class));
                        }
                        else {

                            Toast.makeText(Register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });
    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}