package com.example.vasu.firstapiproject_android.CustomAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.vasu.firstapiproject_android.Model.Genre;
import com.example.vasu.firstapiproject_android.R;

import java.util.ArrayList;


/**
 * Created by VASU on 1/2/2017.
 */
public class CustomAdapterForGenre extends ArrayAdapter<Genre> implements View.OnClickListener,Filterable {

    private ArrayList<Genre> usersList;

    public CustomAdapterForGenre(Context context, int textViewResourceId,
                                 ArrayList<Genre> usersList) {
        super(context, textViewResourceId, usersList);
        this.usersList = new ArrayList<Genre>();
        this.usersList.addAll(usersList);
    }

    @Override
    public void onClick(View v) {

    }


    private class ViewHolder {
        public TextView name ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        final Genre users = usersList.get(position);

        if (convertView == null) {

            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            convertView = vi.inflate(R.layout.list_item_for_genre, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewName);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(users.getName());

        return convertView;

    }




}
