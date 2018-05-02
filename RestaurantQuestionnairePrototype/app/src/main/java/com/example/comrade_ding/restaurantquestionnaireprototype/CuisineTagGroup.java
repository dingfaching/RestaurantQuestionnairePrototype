package com.example.comrade_ding.restaurantquestionnaireprototype;

import java.util.ArrayList;
import java.util.Arrays;

public class CuisineTagGroup {

    private static ArrayList<String> cuisineTags = new ArrayList<String>(Arrays.asList(
            "American",
            "Italian",
            "Mexican",
            "Indian",
            "Middle Eastern",
            "French",
            "Chinese",
            "Japanese",
            "Buffet",
            "Diners",
            "Pub"
    ));

    public static ArrayList<String> getTags() {
        return cuisineTags;
    }

}
