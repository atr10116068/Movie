package com.example.wakhid.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wakhid.movie.search.model.MovieResponse2;
import com.example.wakhid.movie.search.network.ApiService2;
import com.example.wakhid.movie.search.network.RetrofitClient2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class bleng extends AppCompatActivity {
    private String idMovie;
    private TextView vOriginal_title,vTagline,vPopularity,vRelease_date,vOverview;
    private ImageView vBackdrop,vPoster;

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
        getDetail();
    }

    public void getDetail() {
        ApiService2 service = RetrofitClient2.retrofit().create(ApiService2.class);
        Call<MovieResponse2> call = service.getPopuler(idMovie);
        call.enqueue(new Callback<MovieResponse2>() {
            @Override
            public void onResponse(Call<MovieResponse2> call, Response<MovieResponse2> response) {
                MovieResponse2 movieResponse = response.body();

                String backdrop = movieResponse.getBackdrop_path();
                String tagline = movieResponse.getTagline();
                String original_title = movieResponse.getOriginal_title();
                String poster = movieResponse.getPoster_path();
                String popularity = movieResponse.getPopularity();
                String release_date = movieResponse.getRelease_date();
                String overview = movieResponse.getOverview();
                change(backdrop,tagline,original_title,poster,popularity,release_date,overview);
            }

            @Override
            public void onFailure(Call<MovieResponse2> call, Throwable t) {

            }
        });
    }

    public void change(String backdrop,String tagline,String original_title,String poster,String popularity,String release_date,String overview){
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
    }
}
