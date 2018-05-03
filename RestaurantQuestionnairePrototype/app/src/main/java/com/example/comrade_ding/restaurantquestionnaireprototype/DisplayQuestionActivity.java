package com.example.comrade_ding.restaurantquestionnaireprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayQuestionActivity extends AppCompatActivity {

    private final int numQuestions = 6;
    private int questionsAsked = 0;
    private Question currentQuestion;

    private TextView label_questionDisplay;

    private Button btn_answerOne;
    private Button btn_answerTwo;
    private Button btn_quit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_question);

        init_label();
        init_btns();

        askQuestion();

    }

    private void askQuestion() {
        this.currentQuestion = Question.askQuestion();
        if(this.currentQuestion == null) {
            launch_displaySuggestion();
            finish();
        }
        displayQuestion(this.currentQuestion);
        this.questionsAsked++;
    }

    private void displayQuestion(Question question) {
        this.label_questionDisplay.setText(question.getQuestion());
        if(question instanceof BinaryQuestion) {
            this.btn_answerOne.setText(((BinaryQuestion) question).getTagOne());
            this.btn_answerTwo.setText(((BinaryQuestion) question).getTagTwo());
        } else {
            this.btn_answerOne.setText("No");
            this.btn_answerTwo.setText("Yes");
        }
    }

    private void init_label() {
        this.label_questionDisplay = (TextView) findViewById(R.id.label_questionDisplay);
    }

    private void init_btns() {
        this.btn_answerOne = (Button) findViewById(R.id.btn_answerOne);
        this.btn_answerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionsAsked == numQuestions) {
                    launch_displaySuggestion();
                    finish();
                }
                askQuestion();
            }
        });

        this.btn_answerTwo = (Button) findViewById(R.id.btn_answerTwo);
        this.btn_answerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionsAsked == numQuestions) {
                    launch_displaySuggestion();
                    finish();
                }
                askQuestion();
            }
        });

        this.btn_quit = (Button) findViewById(R.id.btn_quit);
        this.btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void launch_displaySuggestion() {
        Intent intent = new Intent(this, DisplaySuggestionActivity.class);
        startActivity(intent);
    }

    private void launch_main() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
