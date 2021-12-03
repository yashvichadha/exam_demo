package com.example.exam_demo.authentiction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exam_demo.ExamList;
import com.example.exam_demo.ForgotPassword;
import com.example.exam_demo.R;
import com.example.exam_demo.database.DbHandler;
import com.example.exam_demo.model.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {


    TextView etemail,etpassword;
    Button loginbtn;


    private FirebaseAuth mAuth;

    private user User;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth= FirebaseAuth.getInstance();

        etemail= findViewById(R.id.loginemail);
        etpassword= findViewById(R.id.loginpass);
        loginbtn=  findViewById(R.id.btnlogin);
      //  forgotpassword=findViewById(R.id.forgotpass);
      //  DbHandler dbHandler = new DbHandler(this);



       // User = new user();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String loginemail=etemail.getText().toString();
                String loginpass=etpassword.getText().toString();
                //User.setEmail(loginemail.toString());
              //  User.setPassword(loginpass.toString());




                if(etemail.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(Login.this, "EMAIL CAN'T BE EMPTY", Toast.LENGTH_SHORT).show();
                }
                if(etpassword.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(Login.this, "PASSWORD CAN'T BE EMPTY", Toast.LENGTH_SHORT).show();
                }else {
                    mAuth.signInWithEmailAndPassword(loginemail, loginpass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Login.this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Login.this, ExamList.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(Login.this, "EMAIL OR PASSWORD NOT MATCH", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }

                /*if (dbHandler.checkuser(etemail.getText().toString().trim(),etpassword.getText().toString().trim())){
                    Toast.makeText(Login.this,"LOGIN SUCCESS",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(Login.this, ExamList.class);
                    startActivity(intent);
                    finish();
                    }


                 */

               // else {
  //                  Toast.makeText(Login.this, "EMAIL OR PASSWORD NOT MATCH", Toast.LENGTH_SHORT).show();
                   // Intent intent= new Intent(Login.this, ExamList.class);
                    //startActivity(intent);

//                }









            }
        });

       /* forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(Login.this, ForgotPassword.class);
                startActivity(intent);



                String loginemail=etemail.getText().toString();
                mAuth.sendPasswordResetEmail(loginemail)

                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(Login.this,"CHECK YOUR EMAIL AND FOLLOW THE LINK TO CHANGE PASSWORD ",Toast.LENGTH_SHORT).show();

                                }
                                else
                                {
                                    Toast.makeText(Login.this,"EMAIL NOT FOUND ",Toast.LENGTH_SHORT).show();
                                }


                            }


                        });


            }
        });

        */

    }


    public void onclicktoRegister(View view) {
            Intent intent = new Intent(Login.this, Signup.class);
      startActivity(intent);

    }

    public void onclicktoforgotpass(View view) {

        Intent intent= new Intent(Login.this, ForgotPassword.class);
        startActivity(intent);


    }
}