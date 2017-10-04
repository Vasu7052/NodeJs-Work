package com.example.vasu.firstapiproject_android.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vasu on 04-10-2017.
 */

public class Genre {

    @SerializedName("name")
    private String name ;

    public Genre(String name){
        this.name = name ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
