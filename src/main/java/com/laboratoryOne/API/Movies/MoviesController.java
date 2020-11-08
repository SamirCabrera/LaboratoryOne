package com.laboratoryOne.API.Movies;

import java.util.ArrayList;
import java.util.Arrays;

import com.laboratoryOne.Model.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
    
    public static ArrayList<Movie> listMovies = new ArrayList<>();

    final Movie x = new Movie("Title", 2000, "Poster");

    @GetMapping("/getAllMovie")
    public ArrayList<Movie> getMovies() {
        listMovies.add(x);
        return listMovies;
    }
}
