package com.example.vasu.firstapiproject_android.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vasu on 04-10-2017.
 */

public class BooksResponse {

    @SerializedName("allBooks")
    private List<Books> results;

    public List<Books> getResults() {
        return results;
    }

    public void setResults(List<Books> results) {
        this.results = results;
    }

}
