package com.moviegrabber.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviegrabber.model.Movie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.io.IOException;

@Path("/movie")
public class MovieData {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private DataAggregator movieGrabber = new DataAggregator();

    @GET
    @Produces("application/json")
    @Path("/{param}")
    public Response getMovie(@PathParam("param") String title) {
        String output = "";

        Movie movie = movieGrabber.getMovieDataByTitle(title);

        ObjectMapper mapper = new ObjectMapper();

        try {
            output = mapper.writeValueAsString(movie);
        } catch (JsonProcessingException e) {
            logger.error(e);
        }

        return Response.status(200).entity(output).build();
    }

    @GET
    @Produces("text/html")
    @Path("/{param}")
    public Response getMovieHTML(@PathParam("param") String title) {
        String output = "<ul>";

        Movie movie = movieGrabber.getMovieDataByTitle(title);

        output += "<li>Title: " + movie.getTitle() + "</li>";
        output += "<li>Year: " + movie.getYear() + "</li>";
        output += "<li>IMDB ID: " + movie.getImdbID() + "</li>";
        output += "<li>Availability:</li>";
        output += "<ul>";

        for (Map.Entry<String, String> entry : movie.getAvailability().entrySet()) {
            output += "<li>" + entry.getKey() + ": " + entry.getValue() + "</li>";
        }

        output += "</ul></ul>";

        return Response.status(200).entity(output).build();
    }
}