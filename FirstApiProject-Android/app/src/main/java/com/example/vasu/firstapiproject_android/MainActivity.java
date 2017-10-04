package com.example.vasu.firstapiproject_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vasu.firstapiproject_android.Model.Genre;
import com.example.vasu.firstapiproject_android.Model.GenreResponse;
import com.example.vasu.firstapiproject_android.helper.ApiClient;
import com.example.vasu.firstapiproject_android.helper.ApiInterface;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /*List<Genre> genre = response.body().getResults();
                Toast.makeText(MainActivity.this, "Number of movies received: " + genre.size() , Toast.LENGTH_SHORT).show();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        apiService.getAllGenreData().enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                int statusCode = response.code();
                List<Genre> genre = response.body().getResults();
                Toast.makeText(MainActivity.this, "Status : " + statusCode , Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Number of movies received: " + genre.size() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t, Toast.LENGTH_LONG).show();
            }
        });

    }
}
