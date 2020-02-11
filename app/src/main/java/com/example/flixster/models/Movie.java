package com.example.flixster.models;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;


public class Movie {

    String posterPath;
    String title;
    String overview;


    public Movie(JSONObject jsonObject) throws JSONException {

        posterPath = jsonObject.getString("poster_Path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }

    public static List<Movie> fromJSONArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));

        }
        return movies;

    }
        public String getPosterPath()
        {

            return String.format("/y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg", posterPath);
        }

        public String getTitle ()
        {

            return title;
        }

        public String getOverView ()
        {

            return overview;
        }


    }



