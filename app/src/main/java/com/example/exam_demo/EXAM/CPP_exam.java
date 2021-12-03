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

import com.example.exam_demo.Result.CPP_result;
import com.example.exam_demo.R;

public class CPP_exam extends AppCompatActivity {

    TextView ques;
    RadioGroup r_group;
    RadioButton rb1,rb2,rb3,rb4;
    Button Nextbtn;
    TextView score;
    String questions[]={
            "Which of the following is called address operator ?",
            "Which of the following is used for comments in C++ ?",
            "Which function is used to read a single character from the console in C++ ?",
            "Who created C++ ?",
            "Which of the following is called insertion/put to operator ?",
            "Wrapping data and its related functionality into a single entity is known as _____________",
            "What does polymorphism in OOPs mean ?",
            "C++ is ______________",
            "Which of the following is not a type of Constructor ?",
            "Out of the following, which is not a member of the class ?"
    };
    String options[]={"*","&","_","%",
            "// comment","/* comment */","both // comment or /* comment */","// comment */",
            "cin.get(ch","getline(ch)","read(ch)","scanf(ch)",
            "Bjarne Stroustrup ","Dennis Ritchie","Ken Thompson","Brian Kernighan",
            "<< ",">>",">","<",
            "Abstraction","Encapsulation","Polymorphism","Modularity",
            "Concept of allowing overiding of functions","Concept of hiding data","Concept of keeping things in differnt modules/files","Concept of wrapping things into a single unit",
            "procedural programming language","object oriented programming language","functional programming language","both procedural and object oriented programming language",
            "Friend constructor","Copy constructor","Default constructor","Parameterized constructor",
            "Static function","Friend function ","Constant function","Virtual function"};


    String answers[]={ "&","both // comment or /* comment */","cin.get(ch","Bjarne Stroustrup ","<< ","Encapsulation",
            "Concept of allowing overiding of functions","both procedural and object oriented programming language",
            "Friend constructor","Friend function"};


    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp_exam);

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
                    Intent intent= new Intent(CPP_exam.this, CPP_result.class);

                    startActivity(intent);

                }
                r_group.clearCheck();

            }
        });
    }
}