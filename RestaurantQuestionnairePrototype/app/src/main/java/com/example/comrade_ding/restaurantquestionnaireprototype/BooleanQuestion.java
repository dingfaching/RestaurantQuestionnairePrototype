package com.example.comrade_ding.restaurantquestionnaireprototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooleanQuestion extends Question {

    private boolean affirmative;
    private ArrayList<String> tags;

    public BooleanQuestion(String question, String... tags) {
        super(question);
        this.tags = new ArrayList(Arrays.asList(tags));
        this.affirmative = false;
    }

    public List<String> getAllTags() {
        return tags;
    }

    public String getTag(int index) {
        return tags.get(index);
    }

    public void setAffirmative(boolean value) {
        this.affirmative = value;
    }

    public boolean getAffirmative() {
        return this.affirmative;
    }
}
