package com.example.vasu.firstapiproject_android;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.vasu.firstapiproject_android.RecyclerViewClickListener.RecyclerItemListener;

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

        rv.addOnItemTouchListener(new RecyclerItemListener(this , new RecyclerItemListener.OnItemClickListener() {
                    @Override public void onItemClick(View view,final int position) {



                    }
                }));


    }

}
