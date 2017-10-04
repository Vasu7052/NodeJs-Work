package com.example.vasu.firstapiproject_android;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
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

import com.example.vasu.firstapiproject_android.Model.BooksResponse;
import com.example.vasu.firstapiproject_android.Model.GenreResponse;
import com.example.vasu.firstapiproject_android.helper.ApiClient;
import com.example.vasu.firstapiproject_android.helper.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab1 extends Fragment {

    EditText etTitle, etGenre, etDescription, etAuthor, etPublisher, etPages;
    Button btnAdd;
    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1, container, false);

        etTitle = v.findViewById(R.id.editTextTitle);
        etGenre = v.findViewById(R.id.editTextGenre);
        etDescription = v.findViewById(R.id.editTextDescription);
        etAuthor = v.findViewById(R.id.editTextAuthor);
        etPublisher = v.findViewById(R.id.editTextPublisher);
        etPages = v.findViewById(R.id.editTextPages);

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
                Intent i = new Intent(getActivity(), ViewBooksListActivity.class);
                i.putExtra("Type", "Genre");
                startActivity(i);
            }
        });


        return v;
    }

    public void add() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        apiService.addBooksData(etTitle.getText().toString(), etGenre.getText().toString(), etDescription.getText().toString()
                , etAuthor.getText().toString(), etPublisher.getText().toString(), etPages.getText().toString()).enqueue(new Callback<BooksResponse>() {
            @Override
            public void onResponse(Call<BooksResponse> call, Response<BooksResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
                    etTitle.setText("");
                    etGenre.setText("");
                    etDescription.setText("");
                    etAuthor.setText("");
                    etPublisher.setText("");
                    etPages.setText("");
                }
            }

            @Override
            public void onFailure(Call<BooksResponse> call, Throwable t) {

            }
        });
    }

    public void update() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        apiService.updateBooksData("59d542644df5451a58f8e081", etTitle.getText().toString()).enqueue(new Callback<BooksResponse>() {
            @Override
            public void onResponse(Call<BooksResponse> call, Response<BooksResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getActivity(), "Updated", Toast.LENGTH_SHORT).show();
                    etTitle.setText("");
                }
            }

            @Override
            public void onFailure(Call<BooksResponse> call, Throwable t) {

            }
        });
    }
}