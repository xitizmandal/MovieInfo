package com.xitiz.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xitiz on 6/20/16.
 * This is a custom adapter made for presenting our elements.
 * RecyclerView provides two methods that we usually override:
 *      - onCreateViewHolder()
 *      - onBindViewHolder()
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    /**
     * A viewHolder for the
     * **/
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public RatingBar ratingBar;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    /**
     * Work of onCreateViewHolder
     * To inflate the view from movie_list_row layout.
     * **/
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    /**
     * Work of onBindViewHolder
     * Set the appropriate data to each value in the row.
     * Match the different elements with the corresponding value.
     * **/

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        holder.ratingBar.setRating(movie.getRating());
    }


    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}