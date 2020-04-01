package com.moviegrabber.jsoup;

import com.moviegrabber.scraper.AvailabilityScraper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleDataPullTest {

    private final Logger logger = LogManager.getLogger(this.getClass());


   /**
     * Tests if the correct number of elements are returned
     * @throws IOException
     */
    @Test
    public void getSidePlatformsTest() throws IOException {
        AvailabilityScraper scraper = new AvailabilityScraper();
        List<String> platforms = scraper.filterSearch("War of the Planet of the Apes", 2017);
        logger.info("Platforms" + platforms);
        assertEquals(5, platforms.size());
    }

    /**
     * Tests if the correct number of elements are returned
     * @throws IOException
     */
    @Test
    public void getTopPlatformsTest() throws IOException {
        AvailabilityScraper scraper = new AvailabilityScraper();
        List<String> platforms = scraper.filterSearch("Jumanji: The next level", 2019);
        logger.info("Platforms" + platforms);
        assertEquals(4, platforms.size());
    }

}
