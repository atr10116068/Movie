package com.example.wakhid.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wakhid.movie.R;
import com.example.wakhid.movie.bleng;
import com.example.wakhid.movie.model.Movie;
import com.example.wakhid.movie.showImage;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movies;
    private Context context;

    public MovieAdapter(Context context,List<Movie> movies){
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder viewHolder, int i) {
        final Movie movie = movies.get(i);

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + movie.getPoster_path())
                .into(viewHolder.img);
        viewHolder.tvTitle.setText(movie.getTitle());
        viewHolder.tvOverview.setText(movie.getOverview());
        viewHolder.tvDate.setText(movie.getRelease_date());
        viewHolder.detail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),bleng.class);
                intent.putExtra("judul",movie.getTitle());
                intent.putExtra("detail",movie.getOverview());
                intent.putExtra("date",movie.getRelease_date());
                intent.putExtra("id",movie.getId());
                v.getContext().startActivity(intent);
            }
        });
        viewHolder.img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),showImage.class);
                intent.putExtra("src","https://image.tmdb.org/t/p/w500" + movie.getPoster_path());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle,tvOverview,tvDate;
        private ImageView img;
        private LinearLayout detail;
        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            detail = itemView.findViewById(R.id.detail);
            tvDate = itemView.findViewById(R.id.date_id);
        }
    }
}
