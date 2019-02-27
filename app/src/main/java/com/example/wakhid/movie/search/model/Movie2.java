package com.example.wakhid.movie.search.model;

import com.google.gson.annotations.SerializedName;

public class Movie2 {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
