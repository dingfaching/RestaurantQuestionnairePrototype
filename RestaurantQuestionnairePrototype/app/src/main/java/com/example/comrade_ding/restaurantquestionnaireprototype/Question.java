package com.example.comrade_ding.restaurantquestionnaireprototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Question {

    private String question;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }

    private static Random rand = new Random();
    private static ArrayList<Integer> alreadyAsked = new ArrayList<Integer>();

    private static ArrayList<Question> sampleQuestions = new ArrayList<Question> (Arrays.asList(
            new BinaryQuestion("Are you in the mood for a quick-bite, or a sit-down meal?", "quick-bite", "sit-down"),
            new BooleanQuestion("Do you want a beer?", "beer"),
            new BinaryQuestion("Small or a large group dining?", "small", "large"),
            new BinaryQuestion("Family restaurant, or adult dining?", "family", "adult"),
            new BooleanQuestion("Would you want some pasta?", "pasta"),
            new BooleanQuestion("Do you want the option to eat outdoors?", "outdoor seating"),
            new BinaryQuestion("Casual or intimate atmosphere?", "casual", "intimate"),
            new BooleanQuestion("Vegetarian options?", "vegetarian"),
            new BooleanQuestion("Do you want some breakfast food?", "Breakfast & Brunch"),
            new BooleanQuestion("How about some coffee?", "Cafe"),
            new BooleanQuestion("How about some barbeque?", "Barbeque")
    ));

    public static Question askQuestion() {
        int index = -1, iterations = 0;
        boolean asked = true;
        while(asked) {
            index = rand.nextInt(sampleQuestions.size());
            if (!alreadyAsked.contains(new Integer(index))) {
                asked = false;
            }
            iterations++;
            if(iterations > sampleQuestions.size()) {
                return null;
            }
        }
        alreadyAsked.add(new Integer(index));
        return sampleQuestions.get(index);
    }

}
