package com.example.exam_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exam_demo.authentiction.Login;
import com.example.exam_demo.authentiction.Signup;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    TextView email;
   // Button forgotpassword;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mAuth= FirebaseAuth.getInstance();
        email = findViewById(R.id.forgotemail);
       // forgotpassword= findViewById(R.id.reset);




        /*forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String memail=email.getText().toString();

                mAuth.sendPasswordResetEmail(memail)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {


                                if(task.isSuccessful())
                                {
                                    Toast.makeText(ForgotPassword.this,"CHECK YOUR EMAIL AND FOLLOW THE LINK TO CHANGE PASSWORD ",Toast.LENGTH_SHORT).show();

                                }
                                else
                                {
                                    Toast.makeText(ForgotPassword.this,"EMAIL NOT FOUND" +
                                            "REGISTER",Toast.LENGTH_SHORT).show();
                                }

                            }
                        });



            }
        });

         */

    }


    public void onclicktoreset(View view) {
        String memail=email.getText().toString().trim();

        if(memail.isEmpty())
        {
            Toast.makeText(ForgotPassword.this,"EMAIL CAN'T BE EMPTY ",Toast.LENGTH_SHORT).show();
        }

        mAuth.sendPasswordResetEmail(memail)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {


                        if(task.isSuccessful())
                        {
                            Toast.makeText(ForgotPassword.this,"CHECK YOUR EMAIL AND FOLLOW THE LINK TO CHANGE PASSWORD ",Toast.LENGTH_SHORT).show();
                            Intent i= new Intent(ForgotPassword.this, Login.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(ForgotPassword.this,"EMAIL NOT FOUND" +
                                    "\n REGISTER",Toast.LENGTH_SHORT).show();
                            Intent i= new Intent(ForgotPassword.this, Signup.class);
                            startActivity(i);
                        }

                    }
                });
    }
}