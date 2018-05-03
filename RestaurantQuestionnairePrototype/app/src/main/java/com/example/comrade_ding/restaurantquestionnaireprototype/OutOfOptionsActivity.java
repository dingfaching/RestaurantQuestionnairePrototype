package com.example.comrade_ding.restaurantquestionnaireprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OutOfOptionsActivity extends AppCompatActivity {

    private Button btn_increaseRange;
    private Button btn_newSearch;
    private Button btn_quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_of_options);


        init_btns();

    }


    private void init_btns() {

        this.btn_increaseRange = (Button) findViewById(R.id.btn_increaseRange);

        this.btn_newSearch = (Button) findViewById(R.id.btn_newSearch);
        this.btn_newSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
}
