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
import com.example.exam_demo.Result.JS_result;

public class JS_Exam extends AppCompatActivity {

    TextView ques;
    RadioGroup r_group;
    RadioButton rb1,rb2,rb3,rb4;
    Button Nextbtn;
    TextView score;

    String questions[]={"JavaScript is a _______ language.",
            "Which of the following is not considered as an error in JavaScript ?",
            "JavaScript can be written ________",
            "The web development environment (JavaScript) offers which standard construct for data validation of the input entered by the user.",
            "A JavaScript program developed on a Unix Machine ________",
            "Do functions in JavaScript necessarily return a value?",
            "The basic difference between JavaScript and Java is _________",
            "When an empty statement is encountered, a JavaScript interpreter ________",
            "JavaScript Code can be called by using _________",
            "Which is a fast C++ based JavaScript interpreter?"
    };
    String options[]={ "Object-Oriented","High-level","Assembly-language","Object-Based ",
            "Syntax error","Missing of semicolons","Division by zero ","Missing of Bracket",
            "directly into JS file and included into HTML ","directly on the server page","directly into HTML pages","directly into the css file",
            "Controlled loop constructs ","Server page access","Client side Event","Permit server-side",
            "will throw errors and exceptions","must be restricted to a Unix Machine only","will work perfectly well on a Windows Machine","will be displayed as a JavaScript text on the browser",
            "It is mandatory","Not necessary","Few functions return values by default ","some functions do not return any value",
            "There is no difference","Functions are considered as fields","Variables are specific","Functions are values, and there is no hard distinction between methods and fields ",
            "Ignores the statement ","Prompts to complete the statement","Throws an error","Shows a warning",
            "RMI","Triggering Event","Preprocessor","Function/Method ",
            "Node","Sockets","Processors","Closures"


    };
    String answers[]={"Object-Based ","Division by zero ","directly into JS file and included into HTML ",
            "Controlled loop constructs ","will work perfectly well on a Windows Machine ","Few functions return values by default ",
            "Functions are values, and there is no hard distinction between methods and fields ","Ignores the statement ",
            "Function/Method ","Node"
            };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_exam);

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
                    Intent intent= new Intent(JS_Exam.this, JS_result.class);
                    startActivity(intent);

                }
                r_group.clearCheck();

            }
        });
    }
}