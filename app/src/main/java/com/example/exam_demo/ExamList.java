package com.example.exam_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.exam_demo.EXAM.CExam;
import com.example.exam_demo.EXAM.CPP_exam;
import com.example.exam_demo.EXAM.HTML_Exam;
import com.example.exam_demo.EXAM.JS_Exam;
import com.example.exam_demo.EXAM.JavaExam;
import com.example.exam_demo.EXAM.PHP_Exam;

public class ExamList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_list);

        setTitle("EXAM LIST");
    }

    public void onclicktojavatest(View view) {
        Intent intent= new Intent(ExamList.this, JavaExam.class);
        startActivity(intent);
    }

    public void onclicktoCExam(View view) {
        Intent intent= new Intent(ExamList.this, CExam.class);
        startActivity(intent);
    }

    public void onclicktoCppExam(View view) {
        Intent intent=new Intent(ExamList.this, CPP_exam.class);
        startActivity(intent);
    }

    public void onclicktoJSExam(View view) {
        Intent intent=new Intent(ExamList.this, JS_Exam.class);
        startActivity(intent);

    }

    public void onclicktohtmlExam(View view) {
        Intent intent=new Intent(ExamList.this, HTML_Exam.class);
        startActivity(intent);
    }

    public void onclicktophpExam(View view) {
        Intent intent=new Intent(ExamList.this, PHP_Exam.class);
        startActivity(intent);
    }
}