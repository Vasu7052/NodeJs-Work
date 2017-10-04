package com.example.vasu.firstapiproject_android;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.vasu.firstapiproject_android.Model.Genre;
import com.example.vasu.firstapiproject_android.Model.GenreResponse;
import com.example.vasu.firstapiproject_android.SlideTabView.SlidingTabLayout;
import com.example.vasu.firstapiproject_android.SlideTabView.ViewPagerAdapter;
import com.example.vasu.firstapiproject_android.helper.ApiClient;
import com.example.vasu.firstapiproject_android.helper.ApiInterface;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Add Books","Add Genre"};
    int Numboftabs =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorPrimary);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

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
