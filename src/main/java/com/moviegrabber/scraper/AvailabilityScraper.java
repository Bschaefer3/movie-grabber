package com.moviegrabber.scraper;

import com.moviegrabber.model.Movie;
import com.moviegrabber.model.MoviePricing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

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
//      Tests title
        Document doc = Jsoup.connect(webPage).get();

//      Retrieves available platform names
        Elements availability = doc.getElementsByClass("i3LlFf");
        List<String> platforms = availability.eachText();
        logger.info(platforms);

        Elements costOnPlatform = doc.getElementsByClass("V8xno");
        List<String> prices = costOnPlatform.eachText();
        logger.info(prices);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < platforms.size(); i++) {
            map.put(platforms.get(i), prices.get(i));
        }

        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry:set) {
            MoviePricing movie = new MoviePricing();

            if        (entry.getKey().equals("Netflix")) {
                movie.setNetflix(entry.getValue());
            } else if (entry.getKey().equals("Youtube")) {
                movie.setYoutube(entry.getValue());
            } else if (entry.getKey().equals("Google Play Movies & TV")) {
                movie.setGooglePlay(entry.getValue());
            } else if (entry.getKey().equals("Vudu")) {
                movie.setVudu(entry.getValue());
            } else if (entry.getKey().equals("Amazon Prime Video")) {
                movie.setAmazonPrime(entry.getValue());
            } else if (entry.getKey().equals("Disney+")) {
                movie.setDisney(entry.getValue());
            } else if (entry.getKey().equals("iTunes")) {
                movie.setiTunes(entry.getValue());
            }
        }

        return platforms;
    }

}