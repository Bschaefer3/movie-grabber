package com.moviegrabber.service;

import com.moviegrabber.model.Movie;
import com.moviegrabber.scraper.AvailabilityScraper;
import com.omdb.OMDBDao;

import java.util.Map;

/**
 * Aggregates the movie data from omdb and google
 */
public class DataAggregator {

    private OMDBDao dao = new OMDBDao();
    private AvailabilityScraper availability = new AvailabilityScraper();

    /**
     * Gets movie data by title.
     *
     * @param title the movie title
     * @return the movie data
     */
    public Movie getMovieDataByTitle(String title) {

        com.omdb.Movie omdbData = dao.getMovieByTitle(title);

        Movie movie = new Movie();

        movie.setTitle(omdbData.getTitle());
        movie.setImdbID(omdbData.getImdbID());
        movie.setYear(omdbData.getYear());

        Map<String, String> pricing = availability.getAvailabilityByTitle(movie.getTitle(), Integer.parseInt(movie.getYear()));

        movie.updateAvailability(pricing);

        return movie;
    }

}
