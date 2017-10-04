package com.example.vasu.firstapiproject_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vasu.firstapiproject_android.helper.ApiClient;
import com.example.vasu.firstapiproject_android.helper.ApiInterface;

public class MainActivity extends AppCompatActivity {

    String BASE_URL = "http://localhost:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    }
}
