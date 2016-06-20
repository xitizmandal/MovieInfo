package com.xitiz.recycler;

/**
 * Created by xitiz on 6/20/16.
 * This is for creating our movie information.
 * Title, genre, year etc are the information we need.
 * When creating a List of movies, i.e., List<Movie> xyz = new ArrayList<>
 *     we can add elements to the list by
 *     xyz.add(movieExample) where movieExample is declared as
 *     Movie movieExample = new Movie("Loot","Comedy","2013")
 */
public class Movie {
    private String title, genre, year;
    private float rating;

    public Movie() {
    }

    public Movie(String title, String genre, String year, float rating) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }
}