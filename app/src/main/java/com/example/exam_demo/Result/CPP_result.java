package com.example.exam_demo.Result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.exam_demo.EXAM.CPP_exam;
import com.example.exam_demo.EXAM.JavaExam;
import com.example.exam_demo.ExamList;
import com.example.exam_demo.R;

public class CPP_result extends AppCompatActivity {

    TextView correctanswer, wronganswer, finalresult;
    Button NextTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp_result);

        correctanswer = findViewById(R.id.correctans);
        wronganswer= findViewById(R.id.wrongans);
        finalresult= findViewById(R.id.final_result);
        NextTest= findViewById(R.id.Nexttest);

        StringBuffer sb =new StringBuffer();
        sb.append("Correct Answers: " + CPP_exam.correct + "\n");
        StringBuffer sb2 =new StringBuffer();
        sb2.append("Wrong Answers: " + JavaExam.wrong + "\n");
        StringBuffer sb3 =new StringBuffer();
        sb3.append("Final Score: " + JavaExam.correct + "/10"+ "\n");

        correctanswer.setText(sb);
        wronganswer.setText(sb2);
        finalresult.setText(sb3);

        JavaExam.correct=0;
        JavaExam.wrong=0;

        NextTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CPP_result.this, ExamList.class);
                startActivity(intent);
            }
        });

    }
}