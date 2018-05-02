package com.example.comrade_ding.restaurantquestionnaireprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_user_prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_btns();

    }

    private void init_btns() {
        // User Preferences
        this.btn_user_prefs =  (Button) findViewById(R.id.btn_user_prefs);
        this.btn_user_prefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch_user_prefs();
            }
        });
        // Start Questionnaire
    }

    private void launch_user_prefs() {
        Intent intent = new Intent(this, UserPreferencesActivity.class);
        startActivity(intent);
    }
}
