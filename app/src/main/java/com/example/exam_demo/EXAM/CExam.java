package com.example.exam_demo.EXAM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exam_demo.Result.CResult;
import com.example.exam_demo.R;

public class CExam extends AppCompatActivity {

    TextView ques;
    RadioGroup r_group;
    RadioButton rb1,rb2,rb3,rb4;
    Button Nextbtn;
    TextView score;
    String questions[]={"Which of the following is not a valid C variable name ?",
            "All keywords in C are in ",
            "Which of the following declaration is not supported by C ?",
            "Functions can return enumeration constants in C ?",
            "Functions in C are always ",
            "What is #include <stdio.h> ?",
            "Which of the following are C preprocessors ?",
            "Which of the following return-type cannot be used for a function in C?",
            "In C language, FILE is of which data type?",
            "scanf() is a predefined function in______header file."


    };
    String options[]={
            "int number;","float rate;","int variable_count;","int $main;",
            "LowerCase letters","UpperCase letters","CamelCase letters","None of the mentioned",
            "String str;","char *str;","float str = 3e2;","Both String str; & float str = 3e2;",
            "true","false","depends on the compiler","depends on the standard",
            "Internal","External","Both Internal and External","External and Internal are not valid terms for functions",
            "Preprocessor directive","Inclusion directive","File inclusion directive","None of the mentioned",
            "#ifdef","#define","#endif","all of the mentioned ",
            "char *","struct","void","none of the mentioned",
            "int","char *","struct","None of the mentioned",
            "stdlib. h","ctype. h","stdio. h","stdarg. h"



    };
    String answers[]={"int $main;","LowerCase letters","String str;","true","External","Preprocessor directive",
            "all of the mentioned ","none of the mentioned","struct","stdio. h",};


    int flag=0;
    public static int marks=0,correct=0,wrong=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cexam);
        Nextbtn= findViewById(R.id.NEXT);
        ques= findViewById(R.id.questions);
        r_group= findViewById(R.id.option);
        rb1= findViewById(R.id.A);
        rb2= findViewById(R.id.B);
        rb3= findViewById(R.id.C);
        rb4= findViewById(R.id.D);
        ques.setText(questions[flag]);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);


        Nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r_group.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = (RadioButton) findViewById(r_group.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }
                flag++;

                if (score != null)
                    score.setText(""+correct);

                if (flag<questions.length)
                {
                    ques.setText(questions[flag]);
                    rb1.setText(options[flag*4]);
                    rb2.setText(options[flag*4 +1]);
                    rb3.setText(options[flag*4 +2]);
                    rb4.setText(options[flag*4 +3]);

                }
                else
                {
                    marks=correct;
                    Intent intent= new Intent(CExam.this, CResult.class);
                    startActivity(intent);

                }
                r_group.clearCheck();

            }
        });

    }
}