package com.along.zhuanhang.ui;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aloong on 2017/5/1.
 */

public class Movie {
    private String mImdbId;
    private String mTitle;
    private String mType;
    private String mYear;
    private String mPosterUrl;
    private Bitmap mPosterBitmap;

    public static Movie fill(JSONObject object){
        Movie movie = new Movie();
        if(object.has("imdbID")){
            movie.setmImdbId(object.optString("imdbID"));
            if (object.has("Title")){
                movie.setmTitle(object.optString("Title"));
            }
            if (object.has("Type")){
                movie.setmType(object.optString("Type"));
            }
            if (object.has("Year")){
                movie.setmYear(object.optString("Year"));
            }
            if (object.has("Poster")){
                movie.setmPosterUrl(object.optString("Poster"));
            }
            return movie;
        }
        return null;
    }

    public static List<Movie> fillList(JSONArray array){
        List<Movie> movies = new ArrayList<>();
        for (int i=0;i<array.length();i++){
            movies.add(fill(array.optJSONObject(i)));
        }
        return movies;
    }

    public String getmImdbId(){
        return mImdbId;
    }
    public Movie setmImdbId(String imbId){
        this.mImdbId = imbId;
        return this;
    }
    public String getmTitle(){
        return mTitle;
    }
    public Movie setmTitle(String title){
        this.mTitle = title;
        return this;
    }
    public String getmType(){
        return mType;
    }
    public Movie setmType(String type){
        this.mType = type;
        return this;
    }
    public String getmYear(){
        return mYear;
    }
    public Movie setmYear(String year){
        this.mYear = year;
        return this;
    }
    public String getmPosterUrl(){
        return mPosterUrl;
    }
    public Movie setmPosterUrl(String posterUrl){
        this.mPosterUrl = posterUrl;
        return this;
    }
    public Bitmap getmPosterBitmap(){
        return mPosterBitmap;
    }
    public Movie setmPosterBitmap(Bitmap posterBitmap){
        this.mPosterBitmap = posterBitmap;
        return this;
    }
}
