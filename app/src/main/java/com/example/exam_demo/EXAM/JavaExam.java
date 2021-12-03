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

import com.example.exam_demo.Result.JAVA_Result;
import com.example.exam_demo.R;

public class JavaExam extends AppCompatActivity {

    TextView ques;
    RadioGroup r_group;
    RadioButton rb1,rb2,rb3,rb4;
    Button Nextbtn;
    TextView score;


    String questions[]={
            "Which of the following option leads to the portability and security of Java ?",
            "Which of the following is not a Java features ?",
            "Every statement in Java language should end with a ?",
            "All methods and variables in Java language are kept inside a ?",
            "In standalone Java applications, which method is mandatory ?",
            "What is the use of Access modifier 'pubic' in Java language?",
            "Choose a Single Line Comment in Java Language below ?",
            "Choose a multiline comment in Java language below?",
            "Name of a Class, Variable, Method or an Interface in Java language is called?",
            "A valid Identifier or name in Java language can start with which character ?"
    };

    String options[]={
            "Bytecode is executed by JVM","The applet makes the Java code secure and portable","Use of exception handling","Dynamic binding between objects",
            "Dynamic","Architecture Neutral","Use of pointers","Object-oriented",
            "Dot or Period","Comma","Semicolon","Colon",
            "File","Class or Interface","static method","main",
            "main method ","show method","display method ","print method",
            "To hide the main method from misuse","To call the main method outside of Class or Package by JVM ","To protect main method","None of the above",
            "//Some comments  ","Some comments//","/*Some comments*/","*/Some comments/*",
            "/*comments are going \n cars are moving*/","*/comments are going\n cars are moving/*","//comments are going\n cars are moving//","None of the above",
            "Argument", "Value","Identifier","None of the above",
            "a-z, A-Z","$, _","0-9","A and B "

    };

    String answers[]={"Bytecode is executed by JVM","Use of pointers","Semicolon","Class or Interface","main method ",
            "To call the main method outside of Class or Package by JVM ","//Some comments  ",
            "/*comments are going\n cars are moving*/ ","Identifier","A and B "};

    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_exam);

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
                Intent intent= new Intent(JavaExam.this, JAVA_Result.class);
                startActivity(intent);

            }
                r_group.clearCheck();

            }
        });

       // Nextbtn.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
         //       Intent intent= new Intent(JavaExam.this,JavaResult.class);
         //       startActivity(intent);
          //  }
       // });


    }
}