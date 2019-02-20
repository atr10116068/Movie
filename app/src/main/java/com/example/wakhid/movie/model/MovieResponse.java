package com.example.wakhid.movie.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResponse {
    @SerializedName("results")
    private ArrayList<Movie> results=null;

    @SerializedName("overview")
    private ArrayList<Movie> overview=null;

    @SerializedName("release_date")
    private ArrayList<Movie> release_date=null;

    @SerializedName("id")
    private ArrayList<Movie> id=null;

    public ArrayList<Movie> getId() {
        return id;
    }

    public void setId(ArrayList<Movie> id) {
        this.id = id;
    }

    public ArrayList<Movie> getRelease_date() {
        return release_date;
    }

    public void setRelease_date(ArrayList<Movie> release_date) {
        this.release_date = release_date;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }

    public ArrayList<Movie> getOverview() {
        return overview;
    }

    public void setOverview(ArrayList<Movie> overview) {
        this.overview = overview;
    }
}
