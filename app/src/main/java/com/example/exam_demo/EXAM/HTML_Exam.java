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
import com.example.exam_demo.Result.HTML_result;

public class HTML_Exam extends AppCompatActivity {


    TextView ques;
    RadioGroup r_group;
    RadioButton rb1,rb2,rb3,rb4;
    Button Nextbtn;
    TextView score;

    String questions[]={
            "HTML is stand for _________",
            "ALL HTML tags are enclosed in what?",
            "To create HTML page, you need _____",
            "<a> and </a> are the tags used for ______",
            "To add a plain color background to your web page, use which of the following?",
            "The BODY tag is usually used after ______",
            "What does the <br> tag add to your webpage?",
            "Which tag tells the browser where the page starts and stops?",
            "Which program do you need to write HTML?",
            "Which tag will you add to specify a font for your whole page?"
    };
    String options[]={
            "Hyper Text Markup Language ","Holistick Technical Method Library","Hyper Tax Makes Line","None of the above",
            "# and #","? and !","< and > ","{ and }",
            "Web browser","text editor","Both [A] and [B] ","None of the above",
            "Adding image","Aligning text","Audio-voiced text","Adding links to your page ",
            "<body bgcolor= “36,24,35”>","<body color= “# FF000”>","<body bgcolor= “# FF000”>","All of the above",
            "HTML tag","EM tag","TITLE tag","HEAD tag ",
            "Long break","Paragraph break","Line break ","None of the above",
            "<html> ","<body>","<head>","<title>",
            "A graphics program","Any text editor ","HTML -development suite 4","All of the above",
            "<defaultfont> ","<targetfont>","<basefont>","<font>"
    };
    String answers[]={"Hyper Text Markup Language ","< and > ","Both [A] and [B] ","Adding links to your page ",
            "<body bgcolor= “# FF000”>","HEAD tag ","Line break ","<html> ","Any text editor ","<defaultfont> "};

    int flag=0;
    public static int marks=0,correct=0,wrong=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_exam);

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
                    Intent intent= new Intent(HTML_Exam.this, HTML_result.class);
                    startActivity(intent);

                }
                r_group.clearCheck();

            }
        });
    }
}