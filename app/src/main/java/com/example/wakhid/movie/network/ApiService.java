package com.example.wakhid.movie.network;

import com.example.wakhid.movie.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String API_KEY = "7cf8ca5a6d487d9bbe52397c1e9c4997";

    @GET("3/movie/popular?api_key="+API_KEY)
    Call<MovieResponse> getPopuler();
}
