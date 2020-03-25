package com.moviegrabber.jsoup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class googleDataPullTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Retrieves the availability of the Oceans 11 movie based on the url
     * @throws IOException
     */
    @Test
    public void getData() throws IOException {
        String url = "https://www.google.com/search?sxsrf=ALeKk01YIZfBoAAfPRzKHPEiIB4o9Rho0Q%3A1585169448182&ei=KMR7Xo_dCpLJtQbL-asI&q=Oceans+11&oq=Oceans+11&gs_l=psy-ab.3..35i39j0i273l2j0l2j0i20i263j0l4.2548.4052..4841...1.2..1.333.1387.1j5j1j1......0....1..gws-wiz.......0i71j0i10j0i22i30.-nOn9rMFgsA&ved=0ahUKEwiPkfiuwLboAhWSZM0KHcv8CgEQ4dUDCAs&uact=5";

//        Tests title
        Document doc = Jsoup.connect(url).get();
        String title = doc.title();
        logger.info(title);
        assertEquals("Oceans 11 - Google Search", title);

        doc.getElementsByClass("i3LlFf");

//        Retrieves availabilities


    }
}
