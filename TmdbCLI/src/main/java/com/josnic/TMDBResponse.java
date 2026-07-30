package com.josnic;

import java.util.ArrayList;
import java.util.LinkedList;

public class TMDBResponse {

    protected class Dates{
        private String maximum;
        private String minimum;

        public String getMaximum(){
            return maximum;
        }
        public String getMinimum(){
            return minimum;
        }

        public void setMaximum(String maximum){
            this.maximum = maximum;
        }
        public void setMinimum(String minimum){
            this.minimum = minimum;
        }
    }

    private Dates dates;
    private int page;
    LinkedList<MovieResult> results;
    private int total_pages;
    private int total_results;

    // Empty constructor
    TMDBResponse(){}

    @Override
    public String toString(){
        String result = "";

        result += "Page: " + page +"\n";
        result += "Results:\n";

        result += "Total pages: " + total_pages + "\n";
        result += "Total results:" + total_results + "\n";

        if(this.dates != null) {
            result += "Maximum date: " + dates.getMaximum();
            result += "Minimum date: " + dates.getMinimum();
        }

        for (MovieResult movie : results){
            result += movie + "\n";
        }

        return result;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public LinkedList<MovieResult> getResults() {
        return results;
    }

    public void setResults(LinkedList<MovieResult> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
