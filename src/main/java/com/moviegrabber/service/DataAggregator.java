package com.moviegrabber.service;

import com.moviegrabber.model.Movie;
import com.omdb.OMDBDao;

public class DataAggregator {

    private OMDBDao dao = new OMDBDao();

    public Movie getMovieDataByTitle(String title) {

        com.omdb.Movie omdbData = dao.getMovieByTitle(title);

        Movie movie = new Movie();

        movie.setTitle(omdbData.getTitle());
        movie.setImdbID(omdbData.getImdbID());
        movie.setYear(omdbData.getYear());
        movie.setAvailableFreeFrom("Netflix");

        return movie;
    }

}
