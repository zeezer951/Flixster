package com.example.flixster.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Context;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;
    public class movieAdapter extends RecyclerView.Adapter<movieAdapter.ViewHolder>
    {
        Context context;
        List<Movie> movies;


        public movieAdapter(Context context, List<Movie> movies){
            this.context = context;
            this.movies = movies;

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View movieView = LayoutInflater.from(context),inflate(R.layout.item_movie, parent, false)
            return new ViewHolder(movieView);

            return null;
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Movie movie = movies.get(position);
            holder.bind(movie); 
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public Object bind;
            TextView tvTitle;
            TextView toOverView;
            ImageView ivPoster;


             public ViewHolder(@NonNull View itemView) {
                super(itemView);



                tvTitle = itemView.findViewById(R.id.tvTitle);
                toOverView = itemView.findViewById(R.id.toOverView);
                ivPoster = itemView.findViewById(R.id.ivPoster);
            }

            public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle);
            tvTitle.setText(movie.getTitle);
            Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
            }
        }

    }
