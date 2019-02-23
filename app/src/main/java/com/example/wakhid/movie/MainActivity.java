package com.example.wakhid.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.wakhid.movie.adapter.MovieAdapter;
import com.example.wakhid.movie.model.Movie;
import com.example.wakhid.movie.model.MovieResponse;
import com.example.wakhid.movie.network.ApiService;
import com.example.wakhid.movie.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        initView();
        getPopuler();
    }

    private void initView(){
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    public void getPopuler(){
        ApiService service = RetrofitClient.retrofit().create(ApiService.class);
        Call<MovieResponse> call = service.getPopuler();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();
                movieList = movieResponse.getResults();

                for(int i=0;i<movieList.size();i++){
                    Movie movie = movieList.get(i);
                    Log.i("awal","result : "+movie.getTitle());
                }
                movieAdapter = new MovieAdapter(getApplicationContext(),movieList);
                recyclerView.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}
