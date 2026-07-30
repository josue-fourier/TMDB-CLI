package com.josnic;

import java.util.ArrayList;
import java.util.LinkedList;

public class MovieResult {
    private boolean adult;
    private String backdrop_path;
    private LinkedList<Integer> genre_ids;
    private int id;
    private String title;
    private String original_language;

    private String original_title;
    private String overview;
    private float popularity;
    private String poster_path;
    private String release_date;
    private Boolean softcore;
    private Boolean video;
    private float vote_average;
    private float vote_count;


    // Empty constructor
    MovieResult(){}

    @Override
    public String toString(){
        String result = "";

        result += "-----------------------------\n";

        result += "Adult: " + adult + "\n";
        result += "Backdrop path: https://image.tmdb.org/t/p/original/" + backdrop_path + "\n";
        result += "Genre ids:\n";

        for (Integer id : genre_ids){
            result += "\tId: " + id + "\n";
        }

        result += "ID: " + id + "\n";
        result += "Title: " + title + "\n";
        result += "Original language: " + original_language + "\n";
        result += "Original title: " + original_title + "\n";
        result += "Overview: " + overview + "\n";
        result += "Popularity: " + popularity +" \n";
        result += "Poster path: https://image.tmdb.org/t/p/original/" + poster_path + "\n";
        result += "Release date: " + release_date + "\n";
        result += "Softcore: " + softcore + "\n";
        result += "Video: " + video + "\n";
        result += "Vote average: " + vote_average + "\n";
        result += "Vote counte: " + vote_count + "\n";

        result += "-----------------------------\n";

        return result;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public LinkedList<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(LinkedList<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Boolean getSoftcore() {
        return softcore;
    }

    public void setSoftcore(Boolean softcore) {
        this.softcore = softcore;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public float getVote_count() {
        return vote_count;
    }

    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }

}
