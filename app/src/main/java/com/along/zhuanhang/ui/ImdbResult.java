package com.along.zhuanhang.ui;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by aloong on 2017/5/1.
 */

public class ImdbResult {
    private JSONArray search;
    private String totalResults;
    private String Response;

    public static ImdbResult fill(JSONObject object){
        ImdbResult imdbResult = new ImdbResult();
        if (object.has("Search")){
            imdbResult.setSearch(object.optJSONArray("Search"));
        }
        if (object.has("TotalResults")){
            imdbResult.setTotalReselts(object.optString("TotalResults"));
        }
        if (object.has("Response")){
            imdbResult.setResponse(object.optString("Response"));
        }
        return imdbResult;
    }

    public JSONArray getSearch(){
        return search;
    }
    public ImdbResult setSearch(JSONArray search){
        this.search = search;
        return this;
    }
    public String getTotalResults(){
        return totalResults;
    }
    public ImdbResult setTotalReselts(String totalReselts){
        this.totalResults = totalReselts;
        return this;
    }
    public String getResponse(){
        return Response;
    }
    public ImdbResult setResponse(String response){
        this.Response = response;
        return this;
    }
}
