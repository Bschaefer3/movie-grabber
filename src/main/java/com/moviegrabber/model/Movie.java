package com.moviegrabber.model;

/**
 * The Movie data that will be returned to the api request
 *
 * @author sdmiller1
 */
public class Movie {

    private String imdbID;
    private String title;
    private String year;
    private String availableFreeFrom;

    public String getAvailableFreeFrom() {
        return availableFreeFrom;
    }

    public void setAvailableFreeFrom(String availableFreeFrom) {
        this.availableFreeFrom = availableFreeFrom;
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
