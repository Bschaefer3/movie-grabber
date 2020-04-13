package com.moviegrabber.jsoup;

import com.moviegrabber.scraper.AvailabilityScraper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleDataPullTest {

    private final Logger logger = LogManager.getLogger(this.getClass());


   /**
     * Tests if the correct number of elements are returned
     * @throws IOException
     */
    @Test
    public void getSidePlatformsTest() {
        AvailabilityScraper scraper = new AvailabilityScraper();
        Map<String, String> platforms = scraper.getAvailabilityByTitle("War of the Planet of the Apes", "2017");

        logger.info("Platforms and price" + platforms);
        assertEquals(5, platforms.size());
    }

    /**
     * Tests if the correct number of elements are returned
     * @throws IOException
     */
    @Test
    public void getTopPlatformsTest() {
        AvailabilityScraper scraper = new AvailabilityScraper();
        Map<String, String> platforms = scraper.getAvailabilityByTitle("Jumanji: The next level", "2019");
        logger.info("Platforms" + platforms);
        assertEquals(4, platforms.size());
    }

    @Test
    public void getAvailabilityByTitleTest() {
        AvailabilityScraper title = new AvailabilityScraper();
        title.getAvailabilityByTitle("", "2009");

    }

}
