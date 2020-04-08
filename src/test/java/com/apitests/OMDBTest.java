package com.apitests;

import com.omdb.Movie;
import com.omdb.OMDBDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OMDBTest {
    @Test
    public void testOMDBJSON() throws Exception {
        Movie movie = new OMDBDao().getMovieByTitle("The Martian");

        assertEquals("The Martian", movie.getTitle());
    }
}
