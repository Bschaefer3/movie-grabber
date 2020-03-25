package com.moviegrabber.apitests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals("big brain", "big brain");
    }

}