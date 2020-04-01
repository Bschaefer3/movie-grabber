package com.moviegrabber.jsoup;

import com.moviegrabber.scraper.AvailabilityScraper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Stereotype;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class googleDataPullTest {

    private final Logger logger = LogManager.getLogger(this.getClass());


    @Test
    public void getUrlTest() {
        AvailabilityScraper scraper = new AvailabilityScraper();

    }

    /**
     * Tests the pullAvailabilty method
     * @throws IOException
     */
    @Test
    public void getAvailabilityTest() throws IOException {
        AvailabilityScraper scraper = new AvailabilityScraper();
        String searchTerm = "Oceans 11";
        int year = 2001;

        List<String> platforms = scraper.filterSearch(searchTerm, year);

        logger.info(platforms);

        assertEquals(5, platforms.size());

    }

    /**
     * Retrieves the availability of the Oceans 11 movie based on the url
     * @throws IOException
     */
    @Test
    public void getTitleTest() throws IOException {
        String url = "https://www.google.com/search?sxsrf=ALeKk01YIZfBoAAfPRzKHPEiIB4o9Rho0Q%3A1585169448182&ei=KMR7Xo_dCpLJtQbL-asI&q=Oceans+11&oq=Oceans+11&gs_l=psy-ab.3..35i39j0i273l2j0l2j0i20i263j0l4.2548.4052..4841...1.2..1.333.1387.1j5j1j1......0....1..gws-wiz.......0i71j0i10j0i22i30.-nOn9rMFgsA&ved=0ahUKEwiPkfiuwLboAhWSZM0KHcv8CgEQ4dUDCAs&uact=5";

//      Tests title
        Document doc = Jsoup.connect(url).get();
        String title = doc.title();
        logger.info(title);
        assertEquals("Oceans 11 - Google Search", title);

//      Retrieves available platform names
        Elements set = doc.getElementsByClass("i3LlFf");
        List<String> platforms = set.eachText();

        assertEquals(5, platforms.size());

        logger.info(platforms);

    }

    /**
     * Tests if the correct number of elements are returned
     * @throws IOException
     */
    @Test
    public void getPlatformsTest() throws IOException {
        String url = "https://www.google.com/search?sxsrf=ALeKk01YIZfBoAAfPRzKHPEiIB4o9Rho0Q%3A1585169448182&ei=KMR7Xo_dCpLJtQbL-asI&q=Oceans+11&oq=Oceans+11&gs_l=psy-ab.3..35i39j0i273l2j0l2j0i20i263j0l4.2548.4052..4841...1.2..1.333.1387.1j5j1j1......0....1..gws-wiz.......0i71j0i10j0i22i30.-nOn9rMFgsA&ved=0ahUKEwiPkfiuwLboAhWSZM0KHcv8CgEQ4dUDCAs&uact=5";

//      Tests title
        Document doc = Jsoup.connect(url).get();

//      Retrieves prices on each platform + names
        Elements platformElements = doc.getElementsByClass("i3LlFf");

        Elements priceElements = doc.getElementsByClass("V8xno");

        List<String> platforms = platformElements.eachText();
        List<String> prices = priceElements.eachText();

        List<String> output = null;


        assertEquals(5, prices.size());

        logger.info(prices);

    }

    /**
     * Tests to see if the availability table is returned correctly
     * Returns divs that aren't appealing
     *
     * @throws IOException
     */
    @Test
    public void getTableTest() throws IOException {
        String url = "https://www.google.com/search?sxsrf=ALeKk01YIZfBoAAfPRzKHPEiIB4o9Rho0Q%3A1585169448182&ei=KMR7Xo_dCpLJtQbL-asI&q=Oceans+11&oq=Oceans+11&gs_l=psy-ab.3..35i39j0i273l2j0l2j0i20i263j0l4.2548.4052..4841...1.2..1.333.1387.1j5j1j1......0....1..gws-wiz.......0i71j0i10j0i22i30.-nOn9rMFgsA&ved=0ahUKEwiPkfiuwLboAhWSZM0KHcv8CgEQ4dUDCAs&uact=5";

//      Tests title
        Document doc = Jsoup.connect(url).get();

//      Get all platform availability data
//        Elements table = doc.getElementsByClass("kp-blk EyBRub fm06If Wnoohf OJXvsb");
//        logger.info(table.outerHtml());


    }
}
