package com.moviegrabber.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The Movie data that will be returned to the api request
 *
 * @author sdmiller1
 */
public class Movie {

    private String imdbID;
    private String title;
    private String year;
    private Map<String, String> availability;

    public Movie() {
        availability = new HashMap<>();
        availability.put("Netflix", "Unknown");
        availability.put("Youtube", "Unknown");
        availability.put("Google Play Movies & TV", "Unknown");
        availability.put("Vudu", "Unknown");
        availability.put("Amazon Prime Video", "Unknown");
        availability.put("iTunes", "Unknown");
        availability.put("Disney+", "Unknown");
    }

    public Map<String, String> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<String, String> availability) {
        this.availability = availability;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
