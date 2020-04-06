package com.moviegrabber.service;

import com.moviegrabber.model.Movie;
import com.moviegrabber.scraper.AvailabilityScraper;
import com.omdb.OMDBDao;

import java.io.IOException;
import java.util.Map;

public class DataAggregator {

    private OMDBDao dao = new OMDBDao();
    private AvailabilityScraper availability = new AvailabilityScraper();

    public Movie getMovieDataByTitle(String title) throws IOException {

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
