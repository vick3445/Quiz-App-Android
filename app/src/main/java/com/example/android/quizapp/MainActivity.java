package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    CardView cardViewAndroid, cardViewJava;
    EditText editText;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewAndroid = findViewById(R.id.cardandroid);
        cardViewJava = findViewById(R.id.cardjava);
        editText = findViewById(R.id.name_field);

        gotoAndroidQuiz();
        gotoJavaQuiz();
    }

    public void gotoAndroidQuiz() {
        cardViewAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = editText.getText().toString();
                Intent gotoAndroid = new Intent(getApplicationContext(), QuizActivity.class);
                gotoAndroid.putExtra("name",String.valueOf(username));
                startActivity(gotoAndroid);

            }
        });
    }

    public void gotoJavaQuiz() {
        cardViewJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = editText.getText().toString();
                Intent gotoJava = new Intent(getApplicationContext(), javaQuiz.class);
                gotoJava.putExtra("score", username);
                startActivity(gotoJava);

            }
        });
    }
}
