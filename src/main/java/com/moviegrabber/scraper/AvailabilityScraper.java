package com.moviegrabber.scraper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * The type Availability scraper.
 */
public class AvailabilityScraper {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Sc.
     */
    Scanner sc;

    /**
     * Filter search list.
     *
     * @param searchTerm the search term
     * @param year       the year
     * @return the list
     * @throws IOException the io exception
     */
    public List<String> filterSearch(String searchTerm, int year) throws IOException {
        String movieTitle = searchTerm.replaceAll(" ", "+");
        List<String> platforms = null;
        String webPage = "";

        try {
            webPage = createUrl(movieTitle, year);
        } catch (IOException e) {
            logger.error(e);
        }

        if (webPage.equals("")) {
            logger.error("Webpage did not return anything...");
        } else {
            platforms = pullAvailability(webPage);
            
            if(platforms.size() == 0) {
                platforms.add("No available platforms");
            }
        }

        return platforms;
    }

    /**
     * Read page string.
     *
     * @param movieTitle the movie title
     * @param year       the year
     * @return the string
     * @throws IOException the io exception
     */
    public String readPage(String movieTitle, int year) throws IOException {
        String search = "https://www.google.com/search?q=" + movieTitle + "+" + year;

        URL url = new URL(search);
        sc = new Scanner(url.openStream());

        StringBuilder sb = new StringBuilder();

        while(sc.hasNext()) {
            sb.append(sc.next());
        }

        return sb.toString();

    }

    /**
     * Create url string.
     *
     * @param movieTitle the movie title
     * @param year       the year
     * @return the string
     * @throws IOException the io exception
     */
    public String createUrl(String movieTitle, int year) throws IOException {
        String search = "https://www.google.com/search?q=" + movieTitle + "+" + year;

        return search;
    }

    /**
     * Pull locations users can view a movie from a google search and return results as a list.
     *
     * @param webPage the web page
     * @return the list
     * @throws IOException the io exception
     */
    public List<String> pullAvailability(String webPage) throws IOException {
        String url = webPage;

        Document doc = Jsoup.connect(url).get();

        Elements platformElements = doc.getElementsByClass("i3LlFf");
        List<String> platforms = null;

        if(platformElements != null) {
            //      Loops through the platforms adding each platform to a list
            platforms = platformElements.eachText();

        } else {
            //      Retrieves prices on each platform + names
            platformElements = doc.getElementsByClass("hl");

            //      Loops through the platforms adding each platform to a list
            platforms = platformElements.eachText();

        }


        return platforms;
    }

}