package com.example.comrade_ding.restaurantquestionnaireprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserPreferencesActivity extends AppCompatActivity {

    private Button btn_save_changes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preferences);

        init_btns();

    }

    private void init_btns() {
        // Save Changes
        this.btn_save_changes = (Button) findViewById(R.id.btn_save_changes);
        this.btn_save_changes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_changes();
                finish();
            }
        });
    }

    private void save_changes() {

    }
}
