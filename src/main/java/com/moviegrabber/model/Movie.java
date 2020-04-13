package com.moviegrabber.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The Movie data that will be returned to the api request
 */
public class Movie {

    private String imdbID;
    private String title;
    private String year;
    private Map<String, String> availability;

    /**
     * Instantiates a new Movie.
     */
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

    /**
     * Update availability.
     *
     * @param availability the availability
     */
    public void updateAvailability(Map<String, String> availability) {
        for (String service: availability.keySet()) {
            if (this.availability.containsKey(service)) {
                this.availability.replace(service, availability.get(service));
            }
        }
    }

    /**
     * Gets availability.
     *
     * @return the availability
     */
    public Map<String, String> getAvailability() {
        return availability;
    }

    /**
     * Sets availability.
     *
     * @param availability the availability
     */
    public void setAvailability(Map<String, String> availability) {
        this.availability = availability;
    }

    /**
     * Gets imdb id.
     *
     * @return the imdb id
     */
    public String getImdbID() {
        return imdbID;
    }

    /**
     * Sets imdb id.
     *
     * @param imdbID the imdb id
     */
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        String result = title + " was released in " + year + " and is available on: ";

        for (Map.Entry<String, String> service: availability.entrySet()) {
            if (!service.getValue().equals("Unknown") && !service.getValue().equals("Subscription")) {
                result += service.getKey() + " for $" + service.getValue() + "; ";
            } else if (service.getValue().equals("Subscription")) {
                result += service.getKey() + " with Subscription; ";
            }
        }

        return result;
    }
}
