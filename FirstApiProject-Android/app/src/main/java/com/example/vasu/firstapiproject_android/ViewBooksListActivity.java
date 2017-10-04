package com.example.vasu.firstapiproject_android;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vasu.firstapiproject_android.CustomAdapter.CustomAdapterForGenre;
import com.example.vasu.firstapiproject_android.Model.Genre;
import com.example.vasu.firstapiproject_android.Model.GenreResponse;
import com.example.vasu.firstapiproject_android.helper.ApiClient;
import com.example.vasu.firstapiproject_android.helper.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewBooksListActivity extends AppCompatActivity {

    ListView lv ;
    ApiInterface apiService ;
    ArrayList<Genre> arraylistGenre = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        lv = (ListView) findViewById(R.id.list);

        showData();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                new SweetAlertDialog(ViewBooksListActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Take Action")
                        .setContentText("Delete or not!!")
                        .setConfirmText("Yes")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                apiService.deleteGenreData(arraylistGenre.get(i).get_id()).enqueue(new Callback<GenreResponse>() {
                                    @Override
                                    public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                                        arraylistGenre.clear();
                                        int statusCode = response.code();
                                        showData();
                                    }

                                    @Override
                                    public void onFailure(Call<GenreResponse> call, Throwable t) {

                                    }
                                });

                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });


    }

    public void showData(){

        apiService.getAllGenreData().enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                int statusCode = response.code();
                List<Genre> genre = response.body().getResults();
                arraylistGenre.addAll(genre) ;
                CustomAdapterForGenre adapter = new CustomAdapterForGenre(ViewBooksListActivity.this , R.layout.list_item_for_genre , arraylistGenre) ;
                lv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Toast.makeText(ViewBooksListActivity.this, "" + t, Toast.LENGTH_LONG).show();
            }
        });
    }

}
