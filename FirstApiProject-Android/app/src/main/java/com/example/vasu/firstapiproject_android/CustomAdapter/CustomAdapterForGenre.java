package com.example.vasu.firstapiproject_android.CustomAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vasu.firstapiproject_android.Model.Genre;
import com.example.vasu.firstapiproject_android.R;

import java.util.List;

public class CustomAdapterForGenre extends RecyclerView.Adapter<CustomAdapterForGenre.MyViewHolder> {

    private List<Genre> genreList;
    private Context context ;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textViewName);

        }

    }



    public CustomAdapterForGenre(List<Genre> countryList) {
        this.genreList = countryList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Genre c = genreList.get(position);
        holder.name.setText(c.getName());

    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_for_genre,parent, false);
        context = parent.getContext();
        return new MyViewHolder(v);
    }

}