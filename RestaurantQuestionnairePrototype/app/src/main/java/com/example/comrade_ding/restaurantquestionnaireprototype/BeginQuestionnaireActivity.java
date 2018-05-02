package com.example.comrade_ding.restaurantquestionnaireprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class BeginQuestionnaireActivity extends AppCompatActivity {

    private Button btn_quick_search;
    private Button btn_advanced_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_questionnaire);

        init_btns();
        init_tag_selection();
    }

    //////////////////////////////////////////////////////////////////
    //          LAUNCH ACTIVITIES                                   //
    //////////////////////////////////////////////////////////////////

    private void launch_displayQuestion() {
        Intent intent = new Intent(this, DisplayQuestionActivity.class);
        startActivity(intent);
    }

    private void launch_displaySuggestion() {
        Intent intent = new Intent(this, DisplaySuggestionActivity.class);
        startActivity(intent);
    }

    //////////////////////////////////////////////////////////////////
    //          INITIALIZE FRAGMENTS                                //
    //////////////////////////////////////////////////////////////////
    private void init_btns() {
        // Save Changes
        this.btn_quick_search = (Button) findViewById(R.id.btn_quick_search);
        this.btn_quick_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch_displaySuggestion();
                finish();
            }
        });

        // Advanced Search
        this.btn_advanced_search = (Button) findViewById((R.id.btn_advanced_search));
        this.btn_advanced_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch_displayQuestion();
                finish();
            }
        });
    }

    private void init_tag_selection() {

        ViewGroup linearLayout = (ViewGroup) findViewById(R.id.layout_cuisineTags);

        ArrayList<String> tags = CuisineTagGroup.getTags();
        int id = 0;
        for(String tag : tags) {
            ToggleButton button = createToggleButton(id, tag);
            linearLayout.addView(button);
            id++;
        }
    }

    private ToggleButton createToggleButton(int id, String tag) {
        ToggleButton newButton = new ToggleButton(this);
        newButton.setId(id);
        newButton.setText(tag);
        newButton.setTextOn(tag);
        newButton.setTextOff(tag);
        newButton.setBackground(getResources().getDrawable(R.drawable.toggle_selector));
        newButton.setTextColor(getResources().getColor(R.color.colorMid));
        newButton.setLayoutParams(new ViewGroup.LayoutParams( ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return newButton;
    }

}
