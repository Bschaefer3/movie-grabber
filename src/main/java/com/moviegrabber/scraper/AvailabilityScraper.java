package com.moviegrabber.scraper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class AvailabilityScraper {

    private final Logger logger = LogManager.getLogger(this.getClass());
    Scanner sc;

    public void filterSearch(String searchTerm, int year) {
        String movieTitle = searchTerm.replaceAll(" ", "+");

        String webPage = "";
        try {
            webPage = readPage(movieTitle, year);
        } catch (IOException e) {
            logger.error(e);
        }

        if (webPage.equals("")) {
            logger.error("Webpage did not return anything...");
        } else {
            pullAvailability(webPage);
        }
    }

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

    public void pullAvailability(String webPage) {

    }

}