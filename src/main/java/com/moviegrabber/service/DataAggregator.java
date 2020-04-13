package com.moviegrabber.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.moviegrabber.model.Movie;
import com.moviegrabber.scraper.AvailabilityScraper;
import com.omdb.OMDBDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * Aggregates the movie data from omdb and google into html or json
 */
public class DataAggregator {

    private OMDBDao dao = new OMDBDao();
    private AvailabilityScraper availability = new AvailabilityScraper();
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Gets movie json by title.
     *
     * @param title the title
     * @return the movie json by title
     */
    public String getMovieJsonByTitle(String title) {

        com.omdb.Movie omdbData = dao.getMovieByTitle(title);

        String movieJson = convertMovieToJson(omdbData);

        return movieJson;
    }

    /**
     * Gets movie json by imdb id.
     *
     * @param imdbId the imdb id
     * @return the movie json by imdb id
     */
    public String getMovieJsonByImdbId(String imdbId) {

        com.omdb.Movie omdbData = dao.getMovieById(imdbId);

        String movieJson = convertMovieToJson(omdbData);

        return movieJson;
    }

    /**
     * Gets movie html by title.
     *
     * @param title the title
     * @return the movie html by title
     */
    public String getMovieHtmlByTitle(String title) {
        com.omdb.Movie omdbData = dao.getMovieByTitle(title);

        String movieHtml = convertMovieToHtml(omdbData);

        return movieHtml;
    }

    /**
     * Gets movie html by imdb id.
     *
     * @param imdbId the imdb id
     * @return the movie html by imdb id
     */
    public String getMovieHtmlByImdbId(String imdbId) {
        com.omdb.Movie omdbData = dao.getMovieById(imdbId);

        String movieHtml = convertMovieToHtml(omdbData);

        return movieHtml;
    }

    /**
     * Gets movie xml by title.
     *
     * @param title the title
     * @return the movie xml by title
     */
    public String getMovieXmlByTitle(String title) {
        com.omdb.Movie omdbData = dao.getMovieByTitle(title);

        String movieXml = convertMovieToXml(omdbData);

        return movieXml;
    }

    /**
     * Gets movie xml by imdb id.
     *
     * @param imdbId the imdb id
     * @return the movie xml by imdb id
     */
    public String getMovieXmlByImdbId(String imdbId) {
        com.omdb.Movie omdbData = dao.getMovieById(imdbId);

        String movieXml = convertMovieToXml(omdbData);

        return movieXml;
    }

    /**
     * Gets movie string by title.
     *
     * @param title the title
     * @return the movie string
     */
    public String getMoviePlainTextByTitle(String title) {
        com.omdb.Movie omdbData = dao.getMovieByTitle(title);

        String movie = convertMovieToPlainText(omdbData);

        return movie;
    }

    /**
     * Gets movie string by imdb id.
     *
     * @param imdbId the imdb id
     * @return the movie string
     */
    public String getMoviePlainTextByImdbId(String imdbId) {
        com.omdb.Movie omdbData = dao.getMovieById(imdbId);

        String movie = convertMovieToPlainText(omdbData);

        return movie;
    }

    /**
     * Convert movie to json string.
     *
     * @param omdbData the omdb data
     * @return the json string
     */
    public String convertMovieToJson(com.omdb.Movie omdbData) {
        String movieJson = "";

        ObjectMapper mapper = new ObjectMapper();

        Movie movie = convertOmdbDataToMovie(omdbData);

        try {
            movieJson = mapper.writeValueAsString(movie);
        } catch (JsonProcessingException e) {
            logger.error(e);
        }

        return movieJson;
    }

    /**
     * Convert movie to html string.
     *
     * @param omdbData the omdb data
     * @return the html string
     */
    public String convertMovieToHtml(com.omdb.Movie omdbData) {
        Movie movie = convertOmdbDataToMovie(omdbData);

        String movieHtml = "<ul>";

        movieHtml += "<li>Title: " + movie.getTitle() + "</li>";
        movieHtml += "<li>Year: " + movie.getYear() + "</li>";
        movieHtml += "<li>IMDB ID: " + movie.getImdbID() + "</li>";
        movieHtml += "<li>Availability:</li>";
        movieHtml += "<ul>";

        for (Map.Entry<String, String> entry : movie.getAvailability().entrySet()) {
            movieHtml += "<li>" + entry.getKey() + ": " + entry.getValue() + "</li>";
        }

        movieHtml += "</ul></ul>";

        return movieHtml;
    }

    /**
     * Convert movie to xml string.
     *
     * @param omdbData the omdb data
     * @return the xml string
     */
    public String convertMovieToXml(com.omdb.Movie omdbData) {
        String movieXml = "";

        XmlMapper xmlMapper = new XmlMapper();

        Movie movie = convertOmdbDataToMovie(omdbData);

        try {
            movieXml = xmlMapper.writeValueAsString(movie);
        } catch (JsonProcessingException e) {
            logger.error(e);
        }

        return movieXml;
    }

    /**
     * Convert movie to plain text string.
     *
     * @param omdbData the omdb data
     * @return the plain text string
     */
    public String convertMovieToPlainText(com.omdb.Movie omdbData) {
        String movieString = "";

        Movie movie = convertOmdbDataToMovie(omdbData);

        movieString = movie.toString();

        return movieString;
    }


    /**
     * Convert omdb data to movie movie.
     *
     * @param omdbData the omdb data
     * @return the movie
     */
    public Movie convertOmdbDataToMovie(com.omdb.Movie omdbData) {
        Movie movie = new Movie();

        movie.setTitle(omdbData.getTitle());
        movie.setImdbID(omdbData.getImdbID());
        movie.setYear(omdbData.getYear());

        Map<String, String> pricing = availability.getAvailabilityByTitle(movie.getTitle(), Integer.parseInt(movie.getYear()));

        movie.updateAvailability(pricing);

        return movie;
    }

}
