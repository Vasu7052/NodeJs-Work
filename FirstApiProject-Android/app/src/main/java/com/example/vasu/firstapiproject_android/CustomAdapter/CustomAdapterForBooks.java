package com.example.vasu.firstapiproject_android.CustomAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.vasu.firstapiproject_android.Model.Books;
import com.example.vasu.firstapiproject_android.Model.Genre;
import com.example.vasu.firstapiproject_android.R;

import java.util.ArrayList;


/**
 * Created by VASU on 1/2/2017.
 */
public class CustomAdapterForBooks extends ArrayAdapter<Books> implements View.OnClickListener,Filterable {

    private ArrayList<Books> usersList;

    public CustomAdapterForBooks(Context context, int textViewResourceId,
                                 ArrayList<Books> usersList) {
        super(context, textViewResourceId, usersList);
        this.usersList = new ArrayList<Books>();
        this.usersList.addAll(usersList);
    }

    @Override
    public void onClick(View v) {

    }


    private class ViewHolder {
        public TextView title ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        final Books users = usersList.get(position);

        if (convertView == null) {

            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            convertView = vi.inflate(R.layout.list_item_for_books, null);

            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.textViewName);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(users.getTitle());

        return convertView;

    }




}
