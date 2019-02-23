package com.example.wakhid.movie.search.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient2 {
    private static Retrofit retrofit;
    private static final String BASE_URL="https://api.themoviedb.org/";

    public static Retrofit retrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
