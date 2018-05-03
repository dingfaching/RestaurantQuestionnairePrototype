package com.example.comrade_ding.restaurantquestionnaireprototype;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class DisplaySuggestionActivity extends AppCompatActivity {

    private Button btn_chose_option;
    private Button btn_next_option;
    private Button btn_quit;
    private TextView label_restaurantName;
    private Restaurant currentRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_suggestion);

        this.label_restaurantName = findViewById(R.id.label_restaurantName);
        init_btns();
        next_restaurant();

    }

    public void next_restaurant() {
        this.currentRestaurant = Restaurant.getRestaurant();
        if(this.currentRestaurant == null) {
            finish();
        }
        display_restaurant(currentRestaurant);

    }

    public void display_restaurant(Restaurant restaurant) {

        this.label_restaurantName.setText(restaurant.getName());

        fill_tags(restaurant);

        Button externalLink = findViewById(R.id.btn_restaurantPage);
        externalLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl(currentRestaurant.getUrl());
            }
        });

    }

    public void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void fill_tags(Restaurant restaurant) {

        ViewGroup horizontalLayout = (ViewGroup) findViewById(R.id.layout_tags);

        ArrayList<String> tags = restaurant.getTags();
        int id = 0;
        for(String tag : tags) {
            TextView button = createLabel(id, tag);
            horizontalLayout.addView(button);
            id++;
        }

    }

    private TextView createLabel(int id, String tag) {
        TextView tagLabel = new TextView(this);
        tagLabel.setText(tag);
        tagLabel.setTextColor(getResources().getColor(R.color.colorLight));
        tagLabel.setTextSize(18.0f);

        return tagLabel;
    }

    private void init_btns() {
        this.btn_quit = (Button) findViewById(R.id.btn_quit);
        this.btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        this.btn_chose_option = (Button) findViewById(R.id.btn_chose_option);
        this.btn_chose_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        this.btn_next_option = (Button) findViewById(R.id.btn_new_option);
        this.btn_next_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_restaurant();
            }
        });
    }
}
