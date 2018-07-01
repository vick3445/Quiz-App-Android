package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app allows you to take a quiz of 10 questions and grades you accordingly.
 */
public class QuizActivity extends AppCompatActivity {

    int score = 0;
    int checkSubmit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        displayScore(score);

        // Textview that shows the username at the start of quiz activity
        TextView showUserName = (TextView) findViewById(R.id.username_text_view);
        showUserName.setText(displayUsername());
    }

    /**
     * Display Username on the quiz screen.
     */
    private String displayUsername() {
        // Get username entered from the previous page and display in the current page
//        Intent myIntent = getIntent();
//        String nameOfUser = myIntent.getStringExtra("EditTextValue");
//        String userNames = getString(R.string.username, nameOfUser);

        String data = getIntent().getStringExtra("name");
        return data;
    }

    /**
     * Display Score before quiz will be taken.
     *
     * @param score takes in the default value of score which is zero.
     */
    private void displayScore(int score) {
        // Set a textview to show the score.
        TextView scoreView = (TextView) findViewById(R.id.score_text_view);
        String scoreDetails = getString(R.string.score, score);
        scoreView.setText(String.valueOf(scoreDetails));
        scoreView.setText("");
    }

    /**
     * This method calculates all ticked radio button that has the correct answer.
     *
     * @param question1_option3 when ticked adds one to the score.
     * @param question2_option3 when ticked adds one to the score.
     * @param question3_option3 when ticked adds one to the score.
     * @param question6_option1 when ticked adds one to the score.
     * @param question7_option1 when ticked adds one to the score.
     * @return accepts the total score if all correct radio button was clicked.
     */
    private int calculateRadioButtons(boolean question1_option3, boolean question2_option3,
                                      boolean question3_option3, boolean question6_option1,
                                      boolean question7_option1) {
        // if user picks option 3 in question 1, add 1 to score.
        if (question1_option3) {
            score += 1;
        }

        // if user picks option 3 in question 2, add 1 to score.
        if (question2_option3) {
            score += 1;
        }

        // if user picks option 3 in question 3, add 1 to score.
        if (question3_option3) {
            score += 1;
        }

        // if user picks option 1 in question 6, add 1 to score.
        if (question6_option1) {
            score += 1;
        }

        // if user picks option 1 in question 7, add 1 to score.
        if (question7_option1) {
            score += 1;
        }

        // calculate the total value of score
        return score;
    }

    /**
     * This method calculates all the correct checkboxes that have been ticked.
     *
     * @param question4_option3 when ticked adds one to the current value of score.
     * @param question5_option1 when ticked adds one to the current value of score.
     * @param question5_option2 when ticked adds one to the current value of score.
     * @param question9_option1 when ticked adds one to the current value of score.
     * @param question9_option4 when ticked adds one to the current value of score.
     * @return will return the new value of score,
     */
    private int calculateCheckBoxes(boolean question4_option3, boolean question5_option1,
                                    boolean question5_option2, boolean question9_option1,
                                    boolean question9_option4) {
        // if user picks option 3 in question 4, add 1 to score.
        if (question4_option3) {
            score += 1;
        }

        // if user picks option 1 in question 5, add 1 to score.
        if (question5_option1) {
            score += 1;
        }

        // if user picks option 2 in question 5, add 1 to score.
        if (question5_option2) {
            score += 1;
        }

        // if user picks option 1 in question 9, add 1 to score.
        if (question9_option1) {
            score += 1;
        }

        // if user picks option 3 in question 1, add 1 to score.
        if (question9_option4) {
            score += 1;
        }

        // calculate the total value of score.
        return score;
    }

    /**
     * This method accepts the input of all edited texts and check if they are correct.
     *
     * @param questionEight accepts the texts entered in question 8.
     * @param questionTen   accepts the textx entered in question 10.
     * @return updates the total value of score if the texts entered are correct.
     */
    private int editInputAnswers(String questionEight, String questionTen) {
        // Get the real answer of question 8 and 10 stored in strings.xml
        String answer8 = getString(R.string.answer8);
        String answer10 = getString(R.string.answer10);

        // if answer entered  for question 8 is matches the real answer,
        // update the value of score and add 5.
        if (questionEight.trim().equalsIgnoreCase(answer8)) {
            score += 5;
        }


        // if answer entered  for question 10 is matches the real answer,
        // update the value of score and add 5.
        if (questionTen.trim().equalsIgnoreCase(answer10)) {
            score += 5;
        }

        // calculate the total value of score
        return score;
    }

    /**
     * This method is called whenever the submit button is clicked.
     */
    public void submitQuiz(View view) {
        // Execute checkQuestions method.
        checkQuestions();

    }

    /**
     * This method is called whenever resets the quiz and resets the quiz to default.
     */
    public void resetQuiz(View view) {
        // Get the ID of radio group Question 1
        RadioGroup groupOne = (RadioGroup) findViewById(R.id.radioGroupOne);

        // Get the ID of radio group Question 2
        RadioGroup groupTwo = (RadioGroup) findViewById(R.id.radioGroupTwo);

        // Get the ID of radio group Question 3
        RadioGroup groupThree = (RadioGroup) findViewById(R.id.radioGroupThree);

        // Get the ID of radio group 6
        RadioGroup groupSix = (RadioGroup) findViewById(R.id.radioGroupSix);

        // Get the ID of radio group 7
        RadioGroup groupSeven = (RadioGroup) findViewById(R.id.radioGroupSeven);

        // Get the ID of Question 4 checkboxes
        CheckBox question4Option1 = (CheckBox) findViewById(R.id.question4_option1);
        CheckBox question4Option2 = (CheckBox) findViewById(R.id.question4_option2);
        CheckBox question4Option3 = (CheckBox) findViewById(R.id.question4_option3);
        CheckBox question4Option4 = (CheckBox) findViewById(R.id.question4_option4);

        // Get the ID of Question 5 checkboxes
        CheckBox question5Option1 = (CheckBox) findViewById(R.id.question5_option1);
        CheckBox question5Option2 = (CheckBox) findViewById(R.id.question5_option2);
        CheckBox question5Option3 = (CheckBox) findViewById(R.id.question5_option3);
        CheckBox question5Option4 = (CheckBox) findViewById(R.id.question5_option4);
        boolean question5_option4 = question5Option4.isChecked();

        // Get the ID of Question 9 checkboxes
        CheckBox question9Option1 = (CheckBox) findViewById(R.id.question9_option1);
        CheckBox question9Option2 = (CheckBox) findViewById(R.id.question9_option2);
        CheckBox question9Option3 = (CheckBox) findViewById(R.id.question9_option3);
        CheckBox question9Option4 = (CheckBox) findViewById(R.id.question9_option4);
        CheckBox question9Option5 = (CheckBox) findViewById(R.id.question9_option5);

        // Getting all EditTexts values for question 8 and question 10.
        EditText quest8 = (EditText) findViewById(R.id.edit_question_8);
        EditText quest10 = (EditText) findViewById(R.id.edit_question_10);

        // Clear all radio buttons in each radio groups that has been checked.
        groupOne.clearCheck();
        groupTwo.clearCheck();
        groupThree.clearCheck();
        groupSix.clearCheck();
        groupSeven.clearCheck();

        // uncheck all checkboxes that has been ticked in question 4
        question4Option1.setChecked(false);
        question4Option2.setChecked(false);
        question4Option3.setChecked(false);
        question4Option4.setChecked(false);

        //Uncheck all checkboxes that has been ticked in question 5
        question5Option1.setChecked(false);
        question5Option2.setChecked(false);
        question5Option3.setChecked(false);
        question5Option4.setChecked(false);

        //Uncheck all checkboxes that has been ticked in question 9
        question9Option1.setChecked(false);
        question9Option2.setChecked(false);
        question9Option3.setChecked(false);
        question9Option4.setChecked(false);
        question9Option5.setChecked(false);

        // Set the values in all EditText boxes to be empty.
        quest8.setText("");
        quest10.setText("");

        // resets the checkSubmit counter
        checkSubmit = 0;

        // resets the score variable to zero
        score = 0;
        displayScore(score);
    }

    /**
     * This method checks if all questions have being answered before submitting
     */
    private void checkQuestions() {
        // Get the ID of radio group Question 1 to ascertain if a radio button has been ticked
        RadioGroup groupOne = (RadioGroup) findViewById(R.id.radioGroupOne);
        int groupOneId = groupOne.getCheckedRadioButtonId();

        // Get the ID of radio group Question 2 to ascertain if a radio button has been ticked
        RadioGroup groupTwo = (RadioGroup) findViewById(R.id.radioGroupTwo);
        int groupTwoId = groupTwo.getCheckedRadioButtonId();

        // Get the ID of radio group Question 3 to ascertain if a radio button has been ticked
        RadioGroup groupThree = (RadioGroup) findViewById(R.id.radioGroupThree);
        int groupThreeId = groupThree.getCheckedRadioButtonId();

        // Get the ID of radio group 6 to ascertain if a radio button has been ticked
        RadioGroup groupSix = (RadioGroup) findViewById(R.id.radioGroupSix);
        int groupSixId = groupSix.getCheckedRadioButtonId();

        // Get the ID of radio group 7 to ascertain if a radio button has been ticked
        RadioGroup groupSeven = (RadioGroup) findViewById(R.id.radioGroupSeven);
        int groupSevenId = groupSeven.getCheckedRadioButtonId();

        // Taking in the vale of any question that has been checked in question 4 and storing it
        CheckBox question4Option1 = (CheckBox) findViewById(R.id.question4_option1);
        boolean question4_option1 = question4Option1.isChecked();
        CheckBox question4Option2 = (CheckBox) findViewById(R.id.question4_option2);
        boolean question4_option2 = question4Option2.isChecked();
        CheckBox question4Option3 = (CheckBox) findViewById(R.id.question4_option3);
        boolean question4_option3 = question4Option3.isChecked();
        CheckBox question4Option4 = (CheckBox) findViewById(R.id.question4_option4);
        boolean question4_option4 = question4Option4.isChecked();

        // Taking in the vale of any question that has been checked in question 5 and storing it
        CheckBox question5Option1 = (CheckBox) findViewById(R.id.question5_option1);
        boolean question5_option1 = question5Option1.isChecked();
        CheckBox question5Option2 = (CheckBox) findViewById(R.id.question5_option2);
        boolean question5_option2 = question5Option2.isChecked();
        CheckBox question5Option3 = (CheckBox) findViewById(R.id.question5_option3);
        boolean question5_option3 = question5Option3.isChecked();
        CheckBox question5Option4 = (CheckBox) findViewById(R.id.question5_option4);
        boolean question5_option4 = question5Option4.isChecked();

        // Taking in the vale of any question that has been checked in question 9 and storing it
        CheckBox question9Option1 = (CheckBox) findViewById(R.id.question9_option1);
        boolean question9_option1 = question9Option1.isChecked();
        CheckBox question9Option2 = (CheckBox) findViewById(R.id.question9_option2);
        boolean question9_option2 = question9Option2.isChecked();
        CheckBox question9Option3 = (CheckBox) findViewById(R.id.question9_option3);
        boolean question9_option3 = question9Option3.isChecked();
        CheckBox question9Option4 = (CheckBox) findViewById(R.id.question9_option4);
        boolean question9_option4 = question9Option4.isChecked();
        CheckBox question9Option5 = (CheckBox) findViewById(R.id.question9_option5);
        boolean question9_option5 = question9Option5.isChecked();

        // Getting all EditTexts values and storing them in question 8
        EditText quest8 = (EditText) findViewById(R.id.edit_question_8);
        String question8 = quest8.getText().toString();

        // Get all EditTexts values and storing them in question 10
        EditText quest10 = (EditText) findViewById(R.id.edit_question_10);
        String question10 = quest10.getText().toString();

        // Variable parameters for calculateRadiobutton method
        RadioButton quest1_opt3 = (RadioButton) findViewById(R.id.question1_option3);
        boolean question1_option3 = quest1_opt3.isChecked();
        RadioButton quest2_opt3 = (RadioButton) findViewById(R.id.question2_option3);
        boolean question2_option3 = quest2_opt3.isChecked();
        RadioButton quest3_opt3 = (RadioButton) findViewById(R.id.question3_option3);
        boolean question3_option3 = quest3_opt3.isChecked();
        RadioButton quest6_opt1 = (RadioButton) findViewById(R.id.question6_option1);
        boolean question6_option1 = quest6_opt1.isChecked();
        RadioButton quest7_opt1 = (RadioButton) findViewById(R.id.question7_option1);
        boolean question7_option1 = quest7_opt1.isChecked();

        // Store all checked parameter to ascertain that at least one option was ticked in
        // question 4
        boolean question4 = question4_option1 || question4_option2 || question4_option3 ||
                question4_option4;

        // Store all checked parameter to ascertain that at least one option was ticked in
        // question 5
        boolean question5 = question5_option1 || question5_option2 || question5_option3 ||
                question5_option4;

        // Store all checked parameter to ascertain that at least one option was ticked in
        // question 9
        boolean question9 = question9_option1 || question9_option2 || question9_option3 ||
                question9_option4 || question9_option5;

        // if no radio button has been checked in radio group 1 after submit button has been clicked
        if (groupOneId == -1) {
            Toast.makeText(this, "Please pick an answer in question 1",
                    Toast.LENGTH_SHORT).show();
        }

        // if no radio button has been checked in radio group 2 after submit button has been clicked
        else if (groupTwoId == -1) {
            Toast.makeText(this, "Please pick an answer in question 2",
                    Toast.LENGTH_SHORT).show();
        }

        // if no radio button has been clicked in radio group 3 after submit button has been clicked
        else if (groupThreeId == -1) {
            Toast.makeText(this, "Please pick an answer in question 3",
                    Toast.LENGTH_SHORT).show();
        }

        // if no radio button has been clicked in radio group 6 after submit button has been clicked
        else if (groupSixId == -1) {
            Toast.makeText(this, "Please pick an answer in question 6",
                    Toast.LENGTH_SHORT).show();
        }

        // if no radio button has been clicked in radio group 7 after submit button has been clicked
        else if (groupSevenId == -1) {
            Toast.makeText(this, "Please pick an answer in question 7",
                    Toast.LENGTH_SHORT).show();
        }

        // if no checkbox was clicked in question 4 after submit button has been clicked
        else if (!question4) {
            Toast.makeText(this, "Please select an answer in question 4",
                    Toast.LENGTH_SHORT).show();
        }

        // if no checkbox was clicked in question 5 after submit button has been clicked
        else if (!question5) {
            Toast.makeText(this, "Please select an answer in question 5",
                    Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(),QuizResult.class);
            startActivity(i);

        }

        // if no checkbox was clicked in question 9 after submit button has been clicked
        else if (!question9) {
            Toast.makeText(this, "Please select an answer in question 9",
                    Toast.LENGTH_SHORT).show();
        }

        // if no text was entered in question 8 after submit button has been clicked
        else if (question8.equals("") || question8.isEmpty()) {
            Toast.makeText(this, "Please answer question 8",
                    Toast.LENGTH_SHORT).show();
        }

        // if no text was entered in question 10 after submit button has been clicked
        else if (question10.equals("") || question10.isEmpty()) {
            Toast.makeText(this, "Please answer question 10",
                    Toast.LENGTH_SHORT).show();
        }

        // check if the questions has been answered withiut hitting the reset button
        else if (checkSubmit > 0) {
            Toast.makeText(this, "Press the reset button",
                    Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, QuizResult.class);
            i.putExtra("score", String.valueOf(score));
            startActivity(i);

        } else {
            //Add one to checksubmit button to avoid the score from being recalculated and added to
            // the previous score if the submit button was pressed more than once.
            checkSubmit += 1;

            // calculate all checkboxes by calling calculateCheckboxes method
            calculateCheckBoxes(question4_option3, question5_option1, question5_option2,
                    question9_option1, question9_option4);

            // calculate all radio buttons by calling calculateRadioButtons method
            calculateRadioButtons(question1_option3, question2_option3, question3_option3,
                    question6_option1, question7_option1);

            // calculate all Text inputs by calling editInputAnswers method
            editInputAnswers(question8, question10);

            // Get the textview that will update the score in the activity
//            TextView scoreView = (TextView) findViewById(R.id.score_text_view);
//            String scoreDetails = String.format(getResources().getString(R.string.score), score);
//            scoreView.setText(scoreDetails);
            displayScore(score);

            String grade;

            if (score < 10) {
                grade = "Not impressive";
            } else if (score == 10) {
                grade = "Average";
            } else if (score <= 19) {
                grade = "Impressive";
            } else {
                grade = "Excellent";
            }

            // Display a toast message to show total score
            Toast.makeText(this, grade + ", your score is " + score + "",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Email your result to a friend
     */
    public void emailResult(View view) {
        // Getting username only
        Intent myIntent = getIntent();
        String nameOfUser = myIntent.getStringExtra("EditTextValue");

        String result = "Name: " + nameOfUser;
        result += "\nMy score: " + score;

        // Create a new intent to send information to any mailing app
        Intent myResult = new Intent(Intent.ACTION_SENDTO);
        myResult.setData(Uri.parse("mailto:"));
        myResult.putExtra(Intent.EXTRA_SUBJECT, "Quiz result for " + nameOfUser);
        myResult.putExtra(Intent.EXTRA_TEXT, result);
        if (myResult.resolveActivity(getPackageManager()) != null) {
            startActivity(myResult);
        }
    }
}



