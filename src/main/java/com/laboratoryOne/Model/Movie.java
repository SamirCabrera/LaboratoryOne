package com.laboratoryOne.Model;

public class Movie {
    
    public Movie() { }

    public Movie(String _title, int _year, String _poster, String _synopsis) {
        this.id = idCounter++; 
        this.title = _title;
        this.year = _year;
        this.poster = _poster;
        this.synopsis = _synopsis;
    }

    private String title;
    private int year;
    private int id;
    private String poster;
    private String synopsis;
    private static int idCounter = 1;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSynopsis() {
        return synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}

