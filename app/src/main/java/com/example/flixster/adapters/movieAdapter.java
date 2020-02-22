package com.example.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
            Log.d("MovieAdapter", "OnCreateViewHolder");
            View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
            return new ViewHolder(movieView);
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Log.d("MovieAdapter", "OnBindViewHolder" + position);
            Movie movie = movies.get(position);
            holder.bind(movie); 
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView tvTitle;
            TextView tvOverView;
            ImageView ivPoster;


             public ViewHolder(@NonNull View itemView) {
                super(itemView);

                tvTitle = itemView.findViewById(R.id.tvTitle);
                tvOverView = itemView.findViewById(R.id.tvOverview);
                ivPoster = itemView.findViewById(R.id.ivPoster);
            }

            public void bind(final Movie movie)
            {
            tvTitle.setText(movie.getTitle());
            tvOverView.setText(movie.getOverView());
            String imageURL;

            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

                imageURL = movie.getBackDropPath();
            } else{

                imageURL = movie.getPosterPath();
            }
            Glide.with(context).load(imageURL).into(ivPoster);
            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, movie.getTitle(), Toast.LENGTH_SHORT).show();


                }
            });


             }
        }

    }
