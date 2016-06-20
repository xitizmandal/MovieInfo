package com.xitiz.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Loot", "Action, Comedy", "2013", (float) 4.2);
        movieList.add(movie);

        movie = new Movie("Kabadi", "Love, Comedy", "2014", (float) 4.5);
        movieList.add(movie);

        movie = new Movie("Bhirkhe lai chinchas", "Unknown", "2015", (float) 2);
        movieList.add(movie);

        movie = new Movie("Kabadi Kabadi", "Love, Comedy", "2016",(float) 3.8);
        movieList.add(movie);

        movie = new Movie("6 ekan 6", "Comedy", "2015", (float) 4);
        movieList.add(movie);

        movie = new Movie("Pashupati Prasad", "Serious, Reality", "2016", (float) 4.6);
        movieList.add(movie);

        movie = new Movie("WarCraft", "Animation, Fantasy", "2016", (float) 4.3);
        movieList.add(movie);

        movie = new Movie("Conjuring 2", "Horror", "2016", (float) 4);
        movieList.add(movie);

        movie = new Movie("Minions", "Animation", "2014", (float) 4.4);
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008", (float) 3.8);
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985", (float) 4.3);
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }
}