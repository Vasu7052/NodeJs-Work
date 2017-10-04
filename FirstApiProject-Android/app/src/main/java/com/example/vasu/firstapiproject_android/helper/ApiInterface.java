package com.example.vasu.firstapiproject_android.helper;

import com.example.vasu.firstapiproject_android.Model.GenreResponse;
import com.google.gson.JsonElement;

import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by Vasu on 04-10-2017.
 */

public interface ApiInterface {

    @GET("/api/genres/")
    void getAllGenreData(Callback<GenreResponse> callback) ;


}
