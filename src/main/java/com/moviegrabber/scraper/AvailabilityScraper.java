package com.moviegrabber.scraper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * The Availability Scraper Class - Scans google search for prices and location of movies
 */
public class AvailabilityScraper {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Get's availability by title, master method that calls on other methods
     *
     * @param searchTerm the search term
     * @param year       the year
     * @return the list
     */
    public Map<String, String> getAvailabilityByTitle(String searchTerm, int year) {
        String movieTitle = searchTerm.replaceAll(" ", "+");
        Map<String, String> map = new HashMap<>();
        String webPage = "";

        webPage = createUrl(movieTitle, year);

        if (webPage.equals("")) {
            logger.error("Webpage did not return anything...");
        } else {
            map = pullAvailability(webPage);

            if(map.size() == 0) {
                map.put("No available platforms", "");
            }
        }

        return map;
    }

    /**
     * Create url string.
     *
     * @param movieTitle the movie title
     * @param year       the year
     * @return the string
     */
    public String createUrl(String movieTitle, int year) {
        String search = "https://www.google.com/search?q=" + movieTitle + "+" + year;

        return search;
    }

    /**
     * Pull locations users can view a movie from a google search and return results as a map.
     *
     * @param webPage the web page
     * @return the list
     */
    public Map<String, String> pullAvailability(String webPage) {
//      Tests title
        Document doc = null;
        try {
            doc = Jsoup.connect(webPage).get();
        } catch(IOException e) {
            logger.error(e);
        }

        Elements availability = doc.getElementsByClass("i3LlFf");
        Elements costOnPlatform = doc.getElementsByClass("V8xno");

//      Retrieves platforms from other section of page
        if(availability.equals(null)) {
            availability = doc.getElementsByClass("hl");
            costOnPlatform = doc.getElementsByClass("ulLPN");
        }

//      Retrieves available platform names
        List<String> platforms = availability.eachText();
        logger.info(platforms);

//      Retrieves available platform prices
        List<String> prices = costOnPlatform.eachText();

//      Checks to see if service is subscription, if not -- grabs price
        for (int i = 0; i < prices.size(); i++) {
            if (!prices.get(i).equals("Subscription")) {
                prices.set(i, prices.get(i).substring(6));
            }
        }

        logger.info(prices);

//      Inserts prices into map
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < platforms.size(); i++) {
            map.put(platforms.get(i), prices.get(i));
        }

        return map;
    }

}