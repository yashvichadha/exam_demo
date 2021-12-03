package com.example.exam_demo.authentiction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exam_demo.R;
import com.example.exam_demo.database.DbHandler;
import com.example.exam_demo.model.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class Signup extends AppCompatActivity {

    DbHandler dbHandler;

    TextView etname,etemail,etmobileno,etpass, etconfirmpass;
    Button btnregister;
    private user User;
    private FirebaseAuth mAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth=FirebaseAuth.getInstance();


        btnregister=findViewById(R.id.btnRegister);
        etname= findViewById(R.id.edttxtNAME);
        etemail= findViewById(R.id.edtttxtEmail);
        etmobileno= findViewById(R.id.editTextPhone);
        etpass= findViewById(R.id.edittxtPassword);
        etconfirmpass= findViewById(R.id.edittxtconfirmPassword);


        dbHandler= new DbHandler(this);

        User= new user();


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                User.setName(etname.getText().toString());
                User.setEmail(etemail.getText().toString());
                User.setPhoneno(etmobileno.getText().toString());
                User.setPassword(etpass.getText().toString());
                String ename= etname.getText().toString();
                String eemail=etemail.getText().toString();
                String emobile=etmobileno.getText().toString();
                String epass= etpass.getText().toString();
                String econfirmpass= etconfirmpass.getText().toString();


                if (ename.isEmpty())
                {
                    Toast.makeText(Signup.this, " NAME CAN'T BE EMPTY", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(eemail.isEmpty()){

                    Toast.makeText(Signup.this,"EMAIL CAN'T BE EMPTY",Toast.LENGTH_SHORT).show();
                    return;

                }
                if(emobile.isEmpty())
                {
                    Toast.makeText(Signup.this,"MOBILE NO CAN'T BE EMPTY",Toast.LENGTH_SHORT).show();
                    return;

                }
                if(epass.isEmpty())
                {
                    Toast.makeText(Signup.this,"PASSWORD NO CAN'T BE EMPTY",Toast.LENGTH_SHORT).show();
                    return;

                }

                if(econfirmpass.isEmpty())
                {
                    Toast.makeText(Signup.this,"CONFIRM PASSWORD NO CAN'T BE EMPTY",Toast.LENGTH_SHORT).show();
                    return;

                }
                if (econfirmpass.equals(epass))
                {

                    mAuth.fetchSignInMethodsForEmail(eemail)
                            .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                                @Override
                                public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {

                                    Boolean ISNEWUSER = task.getResult().getSignInMethods().isEmpty();

                                    if(ISNEWUSER)
                                    {
                                        mAuth.createUserWithEmailAndPassword(eemail,epass)
                                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                                        if(task.isSuccessful()){
                                                            Toast.makeText(Signup.this, "USER CREATED", Toast.LENGTH_SHORT).show();

                                                            etname.setText("");
                                                            etemail.setText("");
                                                            etmobileno.setText("");
                                                            etpass.setText("");
                                                            etconfirmpass.setText("");

                                                            Intent intent= new Intent(Signup.this,Login.class);
                                                            startActivity(intent);
                                                        } else {
                                                            Toast.makeText(Signup.this,"PASSWORD NOT MATCH ",Toast.LENGTH_SHORT).show();
                                                        }


                                                    }
                                                });

                                    }
                                    else
                                        {
                                            Toast.makeText(Signup.this,"USER ALREADY EXISTS",Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                   // dbHandler.addNewUSER(User);







                }



            }
        });

    }

    public void onclicktologin(View view) {
        Intent intent= new Intent(Signup.this,Login.class);
        startActivity(intent);
    }
}