package com.example.comrade_ding.restaurantquestionnaireprototype;

import java.util.ArrayList;
import java.util.Arrays;

public class Restaurant {

    private String name;
    private String url;
    private ArrayList<String> tags;

    public Restaurant(String name, String url, String...tags) {
        this.name = name;
        this.url = url;
        this.tags = new ArrayList<String>(Arrays.asList(tags));
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    private static int index = 0;
    private static ArrayList<Restaurant> sampleRestaurants = new ArrayList<Restaurant>(Arrays.asList(
            new Restaurant("Rhombus Guys Brewing", "https://www.yelp.com/biz/rhombus-guys-brewing-grand-forks", "Breweries"),
            new Restaurant("Bonzers Sandwich Pub", "https://www.yelp.com/biz/bonzers-sandwich-pub-grand-forks?osq=Bonzers", "American (Traditional)", "Sandwiches", "Bars"),
            new Restaurant("Sickies Garage Burgers & Brews", "https://www.yelp.com/biz/sickies-garage-burgers-and-brews-east-grand-forks-2", "Burgers", "American (New)", "Beer Bar")
    ));

    public static Restaurant getRestaurant() {
        if(index > sampleRestaurants.size()) {
            return null;
        }

        Restaurant restaurant = sampleRestaurants.get(index);
        index++;
        return restaurant;
    }



}
