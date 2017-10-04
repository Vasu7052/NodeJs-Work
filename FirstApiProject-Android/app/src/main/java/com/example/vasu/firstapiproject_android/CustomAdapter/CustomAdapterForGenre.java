package com.example.vasu.firstapiproject_android.CustomAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vasu.firstapiproject_android.Model.Genre;
import com.example.vasu.firstapiproject_android.R;

import java.util.List;


public class CustomAdapterForGenre extends RecyclerView.Adapter<CustomAdapterForGenre.MovieViewHolder> {

    private List<Genre> genre;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView name;


        public MovieViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.textViewName);
        }
    }

    public CustomAdapterForGenre(Context context , List<Genre> genre) {
        this.context = context ;
        this.genre = genre;
    }

    @Override
    public CustomAdapterForGenre.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_for_genre, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.name.setText(genre.get(position).getName());
        Toast.makeText(context, ""+genre.get(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return genre.size();
    }
}