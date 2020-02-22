package com.example.flixster.models;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;


public class Movie {

    String posterPath;
    String title;
    String overview;
    String BackDropPath;
    String basePath = "https://image.tmdb.org/t/p/w342";

    public Movie(JSONObject jsonObject) throws JSONException {

        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }

    public static List<Movie> fromJSONArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
            Log.d("movies", "Added movie"+ movies.get(i).title);
        }
        return movies;

    }
        public String getPosterPath()
        {

            return basePath+posterPath;
        }

        public String getTitle ()
        {

            return title;
        }

        public String getOverView ()
        {

            return overview;
        }


        public String getBackDropPath()
        {
            return BackDropPath;
        }

    }



