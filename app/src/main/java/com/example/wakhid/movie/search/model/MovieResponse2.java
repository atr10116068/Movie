package com.example.wakhid.movie.search.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MovieResponse2 {
    @SerializedName("overview")
    private String overview;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("original_title")
    private String original_title;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("genres")
    private ArrayList<Movie2> genres;

    @SerializedName("vote_average")
    private String vote_average;

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public ArrayList<Movie2> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Movie2> genres) {
        this.genres = genres;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getPopularity() {
        String p = "Popularity : "+popularity;
        return p;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getRelease_date() {
        String r = "Release date : "+release_date;
        return r;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
