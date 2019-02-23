package com.example.wakhid.movie.search.network;

import com.example.wakhid.movie.search.model.MovieResponse2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService2 {
    String API_KEY = "7cf8ca5a6d487d9bbe52397c1e9c4997";

    @GET("3/movie/{movie_id}?api_key="+API_KEY)
    Call<MovieResponse2> getPopuler(@Path("movie_id") String movie_id);
}
