package com.moviegrabber.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Processes api requests to get movie data
 */
@Path("/movies")
public class MovieData {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private DataAggregator movieGrabber = new DataAggregator();

    /**
     * Gets movie data in a json format.
     *
     * @param title the movie title
     * @return the movie data
     */
    @GET
    @Produces("application/json")
    @Path("/title={param}")
    public Response getMovieByTitle(@PathParam("param") String title) {
        String output =  movieGrabber.getMovieJsonByTitle(title);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets movie data in an html return format.
     *
     * @param title the title of the movie
     * @return the movie data
     */
    @GET
    @Produces("text/html")
    @Path("/title={param}")
    public Response getMovieHTMLByTitle(@PathParam("param") String title) {
        String output = movieGrabber.getMovieHtmlByTitle(title);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets movie data in an xml return format.
     *
     * @param title the title of the movie
     * @return the movie data
     */
    @GET
    @Produces("text/xml")
    @Path("/title={param}")
    public Response getMovieXMLByTitle(@PathParam("param") String title) {
        String output = movieGrabber.getMovieXmlByTitle(title);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets movie data in an String return format.
     *
     * @param title the title of the movie
     * @return the movie data
     */
    @GET
    @Produces("text/plain")
    @Path("/title={param}")
    public Response getMoviePlainTextByTitle(@PathParam("param") String title) {
        String output = movieGrabber.getMoviePlainTextByTitle(title);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets movie data in a json format.
     *
     * @param imdbId the movie id
     * @return the movie data
     */
    @GET
    @Produces("application/json")
    @Path("/imdbid={param}")
    public Response getMovieJsonByImdbId(@PathParam("param") String imdbId) {

        String output = movieGrabber.getMovieJsonByImdbId(imdbId);

        return Response.status(200).entity(output).build();
    }


    /**
     * Gets movie data in an html return format.
     *
     * @param imdbId the imdb ID of the movie
     * @return the movie data
     */
    @GET
    @Produces("text/html")
    @Path("/imdbid={param}")
    public Response getMovieHTMLByImdbId(@PathParam("param") String imdbId) {
        String output = movieGrabber.getMovieHtmlByImdbId(imdbId);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets movie data in an xml return format.
     *
     * @param imdbId the imdb ID of the movie
     * @return the movie data
     */
    @GET
    @Produces("text/xml")
    @Path("/imdbid={param}")
    public Response getMovieXMLByImdbId(@PathParam("param") String imdbId) {
        String output = movieGrabber.getMovieXmlByImdbId(imdbId);

        return Response.status(200).entity(output).build();
    }

    /**
     * Gets movie data in an String return format.
     *
     * @param imdbId the imdb ID of the movie
     * @return the movie data
     */
    @GET
    @Produces("text/plain")
    @Path("/imdbid={param}")
    public Response getMoviePlainTextByImdbId(@PathParam("param") String imdbId) {
        String output = movieGrabber.getMoviePlainTextByImdbId(imdbId);

        return Response.status(200).entity(output).build();
    }
}