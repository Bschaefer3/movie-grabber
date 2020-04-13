package com.moviegrabber.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataAggregatorTest {

    @Test
    public void getJsonByTitle() {
        String title = "Murder Mystery";
        String expectedJson = "{\"imdbID\":\"tt1618434\",\"title\":\"Murder Mystery\",\"year\":\"2019\",\"availability\":{\"Netflix\":\"Subscription\",\"iTunes\":\"Unknown\",\"Amazon Prime Video\":\"Unknown\",\"Youtube\":\"Unknown\",\"Vudu\":\"Unknown\",\"Disney+\":\"Unknown\",\"Google Play Movies & TV\":\"Unknown\"}}";

        String movieData = new DataAggregator().getMovieJsonByTitle(title);

        assertEquals(expectedJson, movieData);
    }

    @Test
    public void getJsonByImdbId() {
        String id = "tt1618434";
        String expectedJson = "{\"imdbID\":\"tt1618434\",\"title\":\"Murder Mystery\",\"year\":\"2019\",\"availability\":{\"Netflix\":\"Subscription\",\"iTunes\":\"Unknown\",\"Amazon Prime Video\":\"Unknown\",\"Youtube\":\"Unknown\",\"Vudu\":\"Unknown\",\"Disney+\":\"Unknown\",\"Google Play Movies & TV\":\"Unknown\"}}";

        String movieData = new DataAggregator().getMovieJsonByImdbId(id);

        assertEquals(expectedJson, movieData);
    }

    @Test
    public void getHTMLByTitle() {
        String title = "2012";
        String expectedHTML = "<ul><li>Title: 2012</li><li>Year: 2009</li><li>IMDB ID: tt1190080</li><li>Availability:</li><ul><li>Netflix: Subscription</li><li>iTunes: 3.99</li><li>Amazon Prime Video: 2.99</li><li>Youtube: Unknown</li><li>Vudu: 2.99</li><li>Disney+: Unknown</li><li>Google Play Movies & TV: 3.99</li></ul></ul>";

        String movieData = new DataAggregator().getMovieHtmlByTitle(title);

        assertEquals(expectedHTML, movieData);
    }

    @Test
    public void getHTMLByImdbId() {
        String id = "tt1190080";
        String expectedHTML = "<ul><li>Title: 2012</li><li>Year: 2009</li><li>IMDB ID: tt1190080</li><li>Availability:</li><ul><li>Netflix: Subscription</li><li>iTunes: 3.99</li><li>Amazon Prime Video: 2.99</li><li>Youtube: Unknown</li><li>Vudu: 2.99</li><li>Disney+: Unknown</li><li>Google Play Movies & TV: 3.99</li></ul></ul>";

        String movieData = new DataAggregator().getMovieHtmlByImdbId(id);

        assertEquals(expectedHTML, movieData);
    }

    @Test
    public void getXMLByTitle() {
        String title = "Deadpool";
        String expectedXML = "<Movie><imdbID>tt1431045</imdbID><title>Deadpool</title><year>2016</year><availability><Netflix>Unknown</Netflix><iTunes>7.99</iTunes><Amazon Prime Video>3.99</Amazon Prime Video><Youtube>Unknown</Youtube><Vudu>3.99</Vudu><Disney+>Unknown</Disney+><Google Play Movies & TV>3.99</Google Play Movies & TV></availability></Movie>";

        String movieData = new DataAggregator().getMovieXmlByTitle(title);

        assertEquals(expectedXML, movieData);
    }

    @Test
    public void getXMLByImdbId() {
        String id = "tt1431045";
        String expectedXML = "<Movie><imdbID>tt1431045</imdbID><title>Deadpool</title><year>2016</year><availability><Netflix>Unknown</Netflix><iTunes>7.99</iTunes><Amazon Prime Video>3.99</Amazon Prime Video><Youtube>Unknown</Youtube><Vudu>3.99</Vudu><Disney+>Unknown</Disney+><Google Play Movies & TV>3.99</Google Play Movies & TV></availability></Movie>";

        String movieData = new DataAggregator().getMovieXmlByImdbId(id);

        assertEquals(expectedXML, movieData);
    }

    @Test
    public void getPlainTextByTitle() {
        String title = "Zombieland: Double Tap";
        String expectedText = "Zombieland: Double Tap was released in 2019 and is available on: Amazon Prime Video for $19.99; Vudu for $19.99; Google Play Movies & TV for $3.99; ";

        String movieData = new DataAggregator().getMoviePlainTextByTitle(title);

        assertEquals(expectedText, movieData);
    }

    @Test
    public void getPlainTextByImdbId() {
        String id = "tt1560220";
        String expectedText = "Zombieland: Double Tap was released in 2019 and is available on: Amazon Prime Video for $19.99; Vudu for $19.99; Google Play Movies & TV for $3.99; ";

        String movieData = new DataAggregator().getMoviePlainTextByImdbId(id);

        assertEquals(expectedText, movieData);
    }
}
