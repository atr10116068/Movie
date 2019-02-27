package com.example.wakhid.movie;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wakhid.movie.model.Movie;
import com.example.wakhid.movie.model.MovieResponse;
import com.example.wakhid.movie.search.model.Movie2;
import com.example.wakhid.movie.search.model.MovieResponse2;
import com.example.wakhid.movie.search.network.ApiService2;
import com.example.wakhid.movie.search.network.RetrofitClient2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class bleng extends AppCompatActivity {
    private String idMovie;
    private TextView vOriginal_title,vTagline,vPopularity,vRelease_date,vOverview,vGenres,vRate;
    private ImageView vBackdrop,vPoster;
    List<Movie2> movies2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);

        idMovie = getIntent().getStringExtra("aidi");
        vBackdrop = (ImageView) findViewById(R.id.backdrop_path) ;
        vPoster = (ImageView) findViewById(R.id.poster_path) ;
        vOriginal_title = (TextView) findViewById(R.id.original_title);
        vTagline = (TextView) findViewById(R.id.tagline);
        vPopularity = (TextView) findViewById(R.id.popularity);
        vRelease_date = (TextView) findViewById(R.id.release_date);
        vOverview = (TextView) findViewById(R.id.overview);
        vGenres = (TextView) findViewById(R.id.genres);
        vRate = (TextView) findViewById(R.id.rate);
        getDetail();
    }

    public void getDetail() {

        ApiService2 service = RetrofitClient2.retrofit().create(ApiService2.class);
        Call<MovieResponse2> call = service.getPopuler(idMovie);
        call.enqueue(new Callback<MovieResponse2>() {
            @Override
            public void onResponse(Call<MovieResponse2> call, Response<MovieResponse2> response) {
                MovieResponse2 movieResponse = response.body();

                //Untuk array
                String genre = "";
                movies2 = movieResponse.getGenres();
                for(int i=0;i<movies2.size();i++){
                    Movie2 movie2 = movies2.get(i);
                    Log.i("awal","=> : "+movie2.getName());
                    genre = genre+movie2.getName()+", ";
                }


                //Bukan array
                String backdrop = movieResponse.getBackdrop_path();
                String tagline = movieResponse.getTagline();
                String original_title = movieResponse.getOriginal_title();
                String poster = movieResponse.getPoster_path();
                String popularity = movieResponse.getPopularity();
                String release_date = movieResponse.getRelease_date();
                String overview = movieResponse.getOverview();
                String rate = movieResponse.getVote_average();
                change(backdrop,tagline,original_title,poster,popularity,release_date,overview,genre,rate);
            }

            @Override
            public void onFailure(Call<MovieResponse2> call, Throwable t) {

            }
        });
    }

    public void change(String backdrop,String tagline,String original_title,
                       String poster,String popularity,String release_date,
                       String overview,String genre,String rate){
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + backdrop)
                .into(vBackdrop);
        vTagline.setText(tagline);
        vOriginal_title.setText(original_title);
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + poster)
                .into(vPoster);
        vPopularity.setText(popularity);
        vRelease_date.setText(release_date);
        vOverview.setText(overview);
        vGenres.setText(genre);
        vRate.setText(rate);
    }
}
