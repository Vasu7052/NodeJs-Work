package com.example.vasu.firstapiproject_android.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vasu on 04-10-2017.
 */

public class GenreResponse {

    @SerializedName("results")
    private List<Genre> results;

    public List<Genre> getResults() {
        return results;
    }

    public void setResults(List<Genre> results) {
        this.results = results;
    }

}
