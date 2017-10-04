package com.example.vasu.firstapiproject_android;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.vasu.firstapiproject_android.CustomAdapter.CustomAdapterForGenre;
import com.example.vasu.firstapiproject_android.Model.Genre;
import com.example.vasu.firstapiproject_android.Model.GenreResponse;
import com.example.vasu.firstapiproject_android.RecyclerViewClickListener.RecyclerItemListener;
import com.example.vasu.firstapiproject_android.helper.ApiClient;
import com.example.vasu.firstapiproject_android.helper.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewListActivity extends AppCompatActivity {

    RecyclerView rv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        rv = (RecyclerView) findViewById(R.id.list);

        showData();

        rv.addOnItemTouchListener(new RecyclerItemListener(this , new RecyclerItemListener.OnItemClickListener() {
                    @Override public void onItemClick(View view,final int position) {



                    }
                }));


    }

    public void showData(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        apiService.getAllGenreData().enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                int statusCode = response.code();
                List<Genre> genre = response.body().getResults();
                Toast.makeText(ViewListActivity.this, ""+genre.get(1).getName(), Toast.LENGTH_SHORT).show();
                CustomAdapterForGenre adapter = new CustomAdapterForGenre(genre) ;
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Toast.makeText(ViewListActivity.this, "" + t, Toast.LENGTH_LONG).show();
            }
        });
    }

}
