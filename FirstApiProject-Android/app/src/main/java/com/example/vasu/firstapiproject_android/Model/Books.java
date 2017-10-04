package com.example.vasu.firstapiproject_android.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vasu on 04-10-2017.
 */

public class Books {

    @SerializedName("title")
    private String title ;
    @SerializedName("genre")
    private String genre ;
    @SerializedName("decription")
    private String description ;
    @SerializedName("author")
    private String author ;
    @SerializedName("publisher")
    private String publisher ;
    @SerializedName("pages")
    private String pages ;
    @SerializedName("create_date")
    private String create_date ;

    public Books(String title,String genre,String description,String author,String publisher,String pages,String create_date){
        this.title = title ;
        this.genre = genre ;
        this.description = description ;
        this.author = author ;
        this.publisher = publisher ;
        this.pages = pages ;
        this.create_date = create_date ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }


}
