package com.example.vasu.firstapiproject_android.helper;

import com.example.vasu.firstapiproject_android.Model.BooksResponse;
import com.example.vasu.firstapiproject_android.Model.GenreResponse;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Vasu on 04-10-2017.
 */

public interface ApiInterface {

    @GET("api/genres/")
    Call<GenreResponse> getAllGenreData() ;

    @FormUrlEncoded
    @POST("api/genres/add/")
    Call<GenreResponse> addGenreData(
            @Field("name") String name
    ) ;

    @FormUrlEncoded
    @PUT("api/genres/update/{id}")
    Call<GenreResponse> updateGenreData(
            @Path("id") String _id ,
            @Field("name") String name
    ) ;

    @DELETE("api/genres/delete/{id}")
    Call<GenreResponse> deleteGenreData(@Path("id") String genreId);

    //============================================================================================================

    @GET("api/books/")
    Call<BooksResponse> getAllBooksData() ;

    @FormUrlEncoded
    @POST("api/books/add/")
    Call<BooksResponse> addBooksData(
            @Field("title") String title ,
            @Field("genre") String genre ,
            @Field("decription") String decription ,
            @Field("author") String author ,
            @Field("publisher") String publisher ,
            @Field("pages") String pages
    ) ;

    @FormUrlEncoded
    @PUT("api/books/update/{id}")
    Call<BooksResponse> updateBooksData(
            @Path("id") String _id ,
            @Field("title") String title
    ) ;

    @DELETE("api/books/delete/{id}")
    Call<BooksResponse> deleteBooksData(@Path("id") String genreId);

}
