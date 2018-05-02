package com.example.comrade_ding.restaurantquestionnaireprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class UserPreferencesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button btn_save_changes;
    private Spinner dropdown_search_range;
    private List<String> ranges = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preferences);

        init_btns();
        init_dropdown();
        init_tag_selection();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {

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

    private void init_dropdown() {
        // Spinner element
        this.dropdown_search_range = (Spinner) findViewById(R.id.dropdown_search_radius);
        // Spinner click listener
        this.dropdown_search_range.setOnItemSelectedListener(this);
        // Spinner drop down elements
        this.ranges = new ArrayList<String>();
        ranges.add("0.5 Mi");
        ranges.add("1 Mi");
        ranges.add("2 Mi");
        ranges.add("5 Mi");
        ranges.add("10 Mi");
        ranges.add("20 Mi");

        // Create adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, this.ranges);
        // Drop down layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Attaching data adapter to spinner
        this.dropdown_search_range.setAdapter(dataAdapter);

    }

    private void init_tag_selection() {

        ViewGroup linearLayout = (ViewGroup) findViewById(R.id.layout_tag_selection);

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
        newButton.setLayoutParams(new LayoutParams( LayoutParams.FILL_PARENT,
                                                    LayoutParams.WRAP_CONTENT));
        return newButton;
    }

    private void save_changes() {

    }
}
