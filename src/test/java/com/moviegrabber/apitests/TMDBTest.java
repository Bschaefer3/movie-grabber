package com.moviegrabber.apitests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TMDBTest {
//    Testing TheMovieDB.org

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {

    }

    @Test
    void getById() {
        String searchTerm = "Big Brother's Big Brain";
        String urlString = "https://api.themoviedb.org/3/search/movie?&api_key=046dfe8634eaa822f6032db544b57f14&query=" + searchTerm;

        assertEquals("Big Brother's Big Brain", "Big Brother's Big Brain");
    }

    @Test
    public void testswapiJSON() throws Exception {

        String searchTerm = "Big Brother's Big Brain";
        String urlString = "https://api.themoviedb.org/3/search/movie?&api_key=046dfe8634eaa822f6032db544b57f14&query=" + searchTerm;

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(urlString);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        assertEquals("1", response);
    }

}