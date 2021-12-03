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

import com.example.exam_demo.R;
import com.example.exam_demo.Result.CResult;
import com.example.exam_demo.Result.PHP_result;

public class PHP_Exam extends AppCompatActivity {

    TextView ques;
    RadioGroup r_group;
    RadioButton rb1,rb2,rb3,rb4;
    Button Nextbtn;
    TextView score;

    String questions[]={
            "What does PHP stand for?\n\n "+ " i) Personal Home Page\n"+ " ii) Hypertext Preprocessor\n"+"iii) Pretext Hypertext Processor\n"+" iv) Preprocessor Home Page",
            "PHP files have a default file extension of_______",
            "What should be the correct syntax to write a PHP code?",
            "Which statement will output $x on the screen?",
            "Which of the below symbols is a newline character?",
            "If $a = 12 what will be returned when ($a == 12) ? 5 : 1 is executed?",
            "Who is the father of PHP?",
            "How to define a function in PHP?",
            "A function in PHP which starts with __ (double underscore) is known as __________",
            "PHP’s numerically indexed array begin with position ___________"

};
    String options[]={
            "Both i) and iii)","Both ii) and iv)","Only ii)","Both i) and ii)",
            ".html",".xml",".php",".ph",
            "< php >","< ? php ?>","<? ?> ","<?php ?>",
            "echo “\\$x”; ","echo “$$x”;","echo “/$x”;","echo “$x;”;",
            "\\r","\\n ","/n","/r",
            "12","1","Error","5",
            "Rasmus Lerdorf ","Willam Makepiece","Drek Kolkevi","List Barely",
            "function {function body}","data type functionName(parameters) {function body}","functionName(parameters) {function body}","function functionName(parameters) {function body}",
            "Magic Function","Inbuilt Function","Default Function","User Defined Function",
            "1","2","0","-1"

};
    String answers[]={
            "Both i) and ii)",".php","<? ?> ","echo “\\$x”; ","\\n","5",
            "Rasmus Lerdorf ","function functionName(parameters) {function body}",
            "Magic Function","0"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php_exam);

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
                    Intent intent= new Intent(PHP_Exam.this, PHP_result.class);
                    startActivity(intent);

                }
                r_group.clearCheck();

            }
        });
    }
}