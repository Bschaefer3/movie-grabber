package com.moviegrabber.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieDataTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void getJsonByTitle() {
        String title = "Murder Mystery";
        String expectedJson = "{\"imdbID\":\"tt1618434\",\"title\":\"Murder Mystery\",\"year\":\"2019\",\"availability\":{\"Netflix\":\"Subscription\",\"iTunes\":\"Unknown\",\"Amazon Prime Video\":\"Unknown\",\"Youtube\":\"Unknown\",\"Vudu\":\"Unknown\",\"Disney+\":\"Unknown\",\"Google Play Movies & TV\":\"Unknown\"}}";

        Response movieData = new MovieData().getMovieJsonByTitle(title);

        assertEquals(expectedJson, movieData.getEntity());
    }

    @Test
    public void getJsonByImdbId() {
        String id = "tt1618434";
        String expectedJson = "{\"imdbID\":\"tt1618434\",\"title\":\"Murder Mystery\",\"year\":\"2019\",\"availability\":{\"Netflix\":\"Subscription\",\"iTunes\":\"Unknown\",\"Amazon Prime Video\":\"Unknown\",\"Youtube\":\"Unknown\",\"Vudu\":\"Unknown\",\"Disney+\":\"Unknown\",\"Google Play Movies & TV\":\"Unknown\"}}";

        Response movieData = new MovieData().getMovieJsonByImdbId(id);

        assertEquals(expectedJson, movieData.getEntity());
    }

    @Test
    public void getHTMLByTitle() {
        String title = "2012";
        String expectedHTML = "<ul><li>Title: 2012</li><li>Year: 2009</li><li>IMDB ID: tt1190080</li><li>Availability:</li><ul><li>Netflix: Subscription</li><li>iTunes: 3.99</li><li>Amazon Prime Video: 2.99</li><li>Youtube: Unknown</li><li>Vudu: 2.99</li><li>Disney+: Unknown</li><li>Google Play Movies & TV: 3.99</li></ul></ul>";

        Response movieData = new MovieData().getMovieHTMLByTitle(title);

        assertEquals(expectedHTML, movieData.getEntity());
    }

    @Test
    public void getHTMLByImdbId() {
        String id = "tt1190080";
        String expectedHTML = "<ul><li>Title: 2012</li><li>Year: 2009</li><li>IMDB ID: tt1190080</li><li>Availability:</li><ul><li>Netflix: Subscription</li><li>iTunes: 3.99</li><li>Amazon Prime Video: 2.99</li><li>Youtube: Unknown</li><li>Vudu: 2.99</li><li>Disney+: Unknown</li><li>Google Play Movies & TV: 3.99</li></ul></ul>";

        Response movieData = new MovieData().getMovieHTMLByImdbId(id);

        assertEquals(expectedHTML, movieData.getEntity());
    }

    @Test
    public void getXMLByTitle() {
        String title = "Deadpool";
        String expectedXML = "<Movie><imdbID>tt1431045</imdbID><title>Deadpool</title><year>2016</year><availability><Netflix>Unknown</Netflix><iTunes>7.99</iTunes><Amazon Prime Video>3.99</Amazon Prime Video><Youtube>Unknown</Youtube><Vudu>3.99</Vudu><Disney+>Unknown</Disney+><Google Play Movies & TV>3.99</Google Play Movies & TV></availability></Movie>";

        Response movieData = new MovieData().getMovieXMLByTitle(title);

        assertEquals(expectedXML, movieData.getEntity());
    }

    @Test
    public void getXMLByImdbId() {
        String id = "tt1431045";
        String expectedXML = "<Movie><imdbID>tt1431045</imdbID><title>Deadpool</title><year>2016</year><availability><Netflix>Unknown</Netflix><iTunes>7.99</iTunes><Amazon Prime Video>3.99</Amazon Prime Video><Youtube>Unknown</Youtube><Vudu>3.99</Vudu><Disney+>Unknown</Disney+><Google Play Movies & TV>3.99</Google Play Movies & TV></availability></Movie>";

        Response movieData = new MovieData().getMovieXMLByImdbId(id);

        assertEquals(expectedXML, movieData.getEntity());
    }

    @Test
    public void getPlainTextByTitle() {
        String title = "Zombieland: Double Tap";
        String expectedText = "Zombieland: Double Tap was released in 2019 and is available on: Amazon Prime Video for $19.99; Vudu for $19.99; Google Play Movies & TV for $3.99; ";

        Response movieData = new MovieData().getMoviePlainTextByTitle(title);

        assertEquals(expectedText, movieData.getEntity());
    }

    @Test
    public void getPlainTextByImdbId() {
        String id = "tt1560220";
        String expectedText = "Zombieland: Double Tap was released in 2019 and is available on: Amazon Prime Video for $19.99; Vudu for $19.99; Google Play Movies & TV for $3.99; ";

        Response movieData = new MovieData().getMoviePlainTextByImdbId(id);

        assertEquals(expectedText, movieData.getEntity());
    }
}
