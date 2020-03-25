package com.moviegrabber.model;

/**
 * The Movie data that will be returned to the api request
 *
 * @author sdmiller1
 */
public class Movie {

    private String title;
    private String imdbID;
    private String plot;
    private String director;
    private String actors;
    private String year;
    private String genre;

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
     * Gets plot.
     *
     * @return the plot
     */
    public String getPlot() {
        return plot;
    }

    /**
     * Sets plot.
     *
     * @param plot the plot
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }

    /**
     * Gets director.
     *
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets director.
     *
     * @param director the director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets actors.
     *
     * @return the actors
     */
    public String getActors() {
        return actors;
    }

    /**
     * Sets actors.
     *
     * @param actors the actors
     */
    public void setActors(String actors) {
        this.actors = actors;
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

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
