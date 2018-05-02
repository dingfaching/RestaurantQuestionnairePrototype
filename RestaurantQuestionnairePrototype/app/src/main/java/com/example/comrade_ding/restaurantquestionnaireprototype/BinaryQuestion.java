package com.example.comrade_ding.restaurantquestionnaireprototype;

public class BinaryQuestion extends Question {

    private String tagOne;
    private String tagTwo;

    BinaryQuestion(String question, String tagOne, String tagTwo) {
        super(question);
        this.tagOne = tagOne;
        this.tagTwo = tagTwo;
    }

    public String getTagOne() {
        return tagOne;
    }

    public String getTagTwo() {
        return tagTwo;
    }
}
