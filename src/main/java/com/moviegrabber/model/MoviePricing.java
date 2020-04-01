package com.moviegrabber.model;

import java.util.List;

public class MoviePricing {

    private String netflix;
    private String youtube;
    private String googlePlay;
    private String vudu;
    private String amazonPrime;
    private String iTunes;
    private String disney;

    public String getNetflix() {
        return netflix;
    }

    public void setNetflix(String netflix) {
        this.netflix = netflix;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getGooglePlay() {
        return googlePlay;
    }

    public void setGooglePlay(String googlePlay) {
        this.googlePlay = googlePlay;
    }

    public String getVudu() {
        return vudu;
    }

    public void setVudu(String vudu) {
        this.vudu = vudu;
    }

    public String getAmazonPrime() {
        return amazonPrime;
    }

    public void setAmazonPrime(String amazonPrime) {
        this.amazonPrime = amazonPrime;
    }

    public String getiTunes() {
        return iTunes;
    }

    public void setiTunes(String iTunes) {
        this.iTunes = iTunes;
    }

    public String getDisney() {
        return disney;
    }

    public void setDisney(String disney) {
        this.disney = disney;
    }

    @Override
    public String toString() {
        return "MoviePricing{" +
                "netflix='" + netflix + '\'' +
                ", youtube='" + youtube + '\'' +
                ", googlePlay='" + googlePlay + '\'' +
                ", vudu='" + vudu + '\'' +
                ", amazonPrime='" + amazonPrime + '\'' +
                ", iTunes='" + iTunes + '\'' +
                ", disney='" + disney + '\'' +
                '}';
    }
}