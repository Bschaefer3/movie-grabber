package com.apitests;

import com.omdb.Movie;
import com.omdb.OMDBDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OMDBTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void getMovieByIdTest() {
        OMDBDao omdbDao = new OMDBDao();

        Movie movie = omdbDao.getMovieById("tt1190080");

        assertEquals("2012", movie.getTitle());
        logger.info("Genre: " + movie.getGenre());
    }

    @Test
    public void testOMDBJSON() throws Exception {
        Movie movie = new OMDBDao().getMovieByTitle("The Martian");

        assertEquals("The Martian", movie.getTitle());
    }


}
