package com.example.vasu.firstapiproject_android.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vasu on 04-10-2017.
 */

public class Genre {

    @SerializedName("name")
    private String name ;
    @SerializedName("create_date")
    private String create_date ;

    public Genre(String name,String create_date){
        this.name = name ;
        this.create_date = create_date ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

}
