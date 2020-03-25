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

public class AvailabilityScraper {

    private final Logger logger = LogManager.getLogger(this.getClass());
    Scanner sc;

    public List<String> filterSearch(String searchTerm, int year) throws IOException {
        String movieTitle = searchTerm.replaceAll(" ", "+");
        List<String> platforms = null;
        String webPage = "";

        try {
            webPage = readPage(movieTitle, year);
        } catch (IOException e) {
            logger.error(e);
        }

        logger.info(webPage);

        if (webPage.equals("")) {
            logger.error(webPage + ": Webpage did not return anything...");
        } else {
            platforms = pullAvailability(webPage);
            
            if(platforms.size() == 0) {
                platforms.add("No available platforms");
            }
        }

        return platforms;
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

    public List<String> pullAvailability(String webPage) throws IOException {
        String url = webPage;

//      Tests title
        Document doc = Jsoup.connect(url).get();

//      Retrieves available platform names
        Elements set = doc.getElementsByClass("i3LlFf");
        List<String> platforms = set.eachText();

        logger.info(platforms);

        return platforms;
    }

}