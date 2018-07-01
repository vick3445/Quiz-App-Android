package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {

    TextView textView;
    int finalscore ;
    Button buttonEmail,buttonRetry,buttonQuiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        textView = findViewById(R.id.quiz_result);
        buttonEmail = findViewById(R.id.emailbtn);
        buttonRetry = findViewById(R.id.btnretry);

        String data = getIntent().getStringExtra("score");

        finalscore = Integer.parseInt(data);
        textView.setText(data);

        sendEmail();
        takeAnotherQuiz();
    }

    public void showAnswers(View v){
        Intent i = new Intent(this,QuizActivity.class);
        startActivity(i);
    }


    public void takeAnotherQuiz() {
           buttonRetry.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i = new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(i);
               }
           });


        }

        public void sendEmail(){
        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    // Getting username only
                    Intent myIntent = getIntent();
                    String nameOfUser = myIntent.getStringExtra("EditTextValue");

                    String result = "Name: " + nameOfUser;

                    result += "\n My finalscore: " + finalscore;

                    // Create a new intent to send information to any mailing app
                    Intent myResult = new Intent(Intent.ACTION_SENDTO);
                    myResult.setData(Uri.parse("mailto:"));
                    myResult.putExtra(Intent.EXTRA_SUBJECT, "Quiz result for " + nameOfUser);
                    myResult.putExtra(Intent.EXTRA_TEXT, result);
                    if (myResult.resolveActivity(getPackageManager()) != null) {
                        startActivity(myResult);
                    }

            }
        });
        }
}
