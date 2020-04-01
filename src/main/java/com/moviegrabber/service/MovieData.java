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
}