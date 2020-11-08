package com.laboratoryOne.Model;

public class Movie {
    
    public Movie() { }

    public Movie(String _title, int _year, String _imgPoster) {
        this.id = idCounter++; 
        this.title = _title;
        this.year = _year;
        this.imgPoster = _imgPoster;
    }

    private String title;
    private int year;
    private String imgPoster;
    private int id;
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

    public String getImgPoster() {
        return imgPoster;
    }

    public void setImgPoster(String imgPoster) {
        this.imgPoster = imgPoster;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
