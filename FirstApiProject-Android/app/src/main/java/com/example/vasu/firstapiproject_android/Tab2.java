package com.example.vasu.firstapiproject_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vasu.firstapiproject_android.Model.Genre;
import com.example.vasu.firstapiproject_android.Model.GenreResponse;
import com.example.vasu.firstapiproject_android.helper.ApiClient;
import com.example.vasu.firstapiproject_android.helper.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab2 extends Fragment {

    EditText etName ;
    Button btnAdd ;
    FloatingActionButton fab ;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_2,container,false);

        etName = v.findViewById(R.id.editTextTitle);
        btnAdd = v.findViewById(R.id.buttonAdd);
        fab = v.findViewById(R.id.floatingActionButton);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });

        btnAdd.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                update();
                return true;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity() , ViewListActivity.class);
                i.putExtra("Type" , "Genre") ;
                startActivity(i);
            }
        });


        return v;
    }

    public void add(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        apiService.addGenreData(etName.getText().toString()).enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getActivity() , "Added" , Toast.LENGTH_SHORT).show();
                    etName.setText("");
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {

            }
        });
    }

    public void update(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        apiService.updateGenreData( "59d3a1e20baa3424465e5bf2" , etName.getText().toString()).enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getActivity() , "Updated" , Toast.LENGTH_SHORT).show();
                    etName.setText("");
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {

            }
        });
    }

}
