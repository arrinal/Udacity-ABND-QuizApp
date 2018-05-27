package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Variable for correct and incorrect score
     */
    int scoreCorrect = 0;
    int scoreIncorrect = 0;

    /**
     * Function for submit the answer button
     */
    public void submitAnswer(View v) {

        /**
         * Function to check if the button already checked or not
         */
        RadioButton questionOne = findViewById(R.id.key_1);
        boolean keyOne = questionOne.isChecked();

        RadioButton questionOneA = findViewById(R.id.notKey_1a);
        boolean notKeySatuA = questionOneA.isChecked();

        RadioButton questionOneB = findViewById(R.id.notKey_1b);
        boolean notKeySatuB = questionOneB.isChecked();

        RadioButton questionTwo = findViewById(R.id.key_2);
        boolean keyTwo = questionTwo.isChecked();

        RadioButton questionTwoA = findViewById(R.id.notKey_2a);
        boolean notKeyDuaA = questionTwoA.isChecked();

        RadioButton questionTwoB = findViewById(R.id.notKey_2b);
        boolean notKeyDuaB = questionTwoB.isChecked();

        RadioButton questionThree = findViewById(R.id.key_3);
        boolean keyThree = questionThree.isChecked();

        RadioButton questionThreeA = findViewById(R.id.notKey_3a);
        boolean notKeyTigaA = questionThreeA.isChecked();

        RadioButton questionThreeB = findViewById(R.id.notKey_3b);
        boolean notKeyTigaB = questionThreeB.isChecked();

        RadioButton questionFour = findViewById(R.id.key_4);
        boolean keyFour = questionFour.isChecked();

        RadioButton questionFourA = findViewById(R.id.notKey_4a);
        boolean notKeyEmpatA = questionFourA.isChecked();

        RadioButton questionFourB = findViewById(R.id.notKey_4b);
        boolean notKeyEmpatB = questionFourB.isChecked();

        RadioButton questionFive = findViewById(R.id.key_5);
        boolean keyFive = questionFive.isChecked();

        RadioButton questionFiveA = findViewById(R.id.notKey_5a);
        boolean notKeyLimaA = questionFiveA.isChecked();

        RadioButton questionFiveB = findViewById(R.id.notKey_5b);
        boolean notKeyLimaB = questionFiveB.isChecked();

        /**
         * Function to make sure all question already answered after check the submit button
         */
        if ((keyOne || notKeySatuA || notKeySatuB) != true) {
            displayToast(getString(R.string.toast_one));
            return;
        }

        if ((keyTwo || notKeyDuaA || notKeyDuaB) != true) {
            displayToast(getString(R.string.toast_two));
            return;
        }

        if ((keyThree || notKeyTigaA || notKeyTigaB) != true) {
            displayToast(getString(R.string.toast_three));
            return;
        }

        if ((keyFour || notKeyEmpatA || notKeyEmpatB) != true) {
            displayToast(getString(R.string.toast_four));
            return;
        }

        if ((keyFive || notKeyLimaA || notKeyLimaB) != true) {
            displayToast(getString(R.string.toast_five));
            return;
        }


        /**
         * Function to check whether the answer is true or not
         * And calculate the correct and incorrect score
         */
        if (keyOne == true) {
            scoreCorrect = scoreCorrect + 1;
        } else {
            scoreIncorrect = scoreIncorrect + 1;
        }

        if (keyTwo == true) {
            scoreCorrect = scoreCorrect + 1;
        } else {
            scoreIncorrect = scoreIncorrect + 1;
        }

        if (keyThree == true) {
            scoreCorrect = scoreCorrect + 1;
        } else {
            scoreIncorrect = scoreIncorrect + 1;
        }

        if (keyFour == true) {
            scoreCorrect = scoreCorrect + 1;
        } else {
            scoreIncorrect = scoreIncorrect + 1;
        }

        if (keyFive == true) {
            scoreCorrect = scoreCorrect + 1;
        } else {
            scoreIncorrect = scoreIncorrect + 1;
        }

        /**
         * Display the score result
         * Display score  result in toast
         */
        displayMessage(result());
        displayToast(getString(R.string.result_toast) + " " + scoreCorrect * 20);

        /**
         * Reset the score to 0
         */
        scoreCorrect = 0;
        scoreIncorrect = 0;
    }

    /**
     * Function to reset all answer include radio button, summary result
     */
    public void reset(View v) {
        RadioGroup varGroup1 = findViewById(R.id.radioGroup1);
        varGroup1.clearCheck();

        RadioGroup varGroup2 = findViewById(R.id.radioGroup2);
        varGroup2.clearCheck();

        RadioGroup varGroup3 = findViewById(R.id.radioGroup3);
        varGroup3.clearCheck();

        RadioGroup varGroup4 = findViewById(R.id.radioGroup4);
        varGroup4.clearCheck();

        RadioGroup varGroup5 = findViewById(R.id.radioGroup5);
        varGroup5.clearCheck();

        displayMessage("\n");
    }

    /**
     * Summary text for score result
     *
     * @return the text
     */
    private String result() {
        String resultSummary = "\n" + getString(R.string.result_totalCorrect) + " " + scoreCorrect;
        resultSummary += "\n" + getString(R.string.result_totalIncorrect) + " " + scoreIncorrect;
        resultSummary += "\n" + getString(R.string.result_score) + " " + scoreCorrect * 20 + "\n";
        return resultSummary;
    }

    /**
     * Function to display the message
     *
     * @param message used as input message
     */
    private void displayMessage(String message) {
        TextView summary = findViewById(R.id.result);
        summary.setText("" + message);
    }

    /**
     * Function to display the toast message
     *
     * @param message used as input message
     */
    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
