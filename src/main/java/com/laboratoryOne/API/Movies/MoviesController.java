package com.laboratoryOne.API.Movies;

import java.util.ArrayList;
import java.util.Arrays;

import com.laboratoryOne.Model.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
    
    public static ArrayList<Movie> listMovies = new ArrayList<>(Arrays.asList(new Movie("Title1", 2001, "Poster1"), new Movie("Title2", 2002, "Poster ")));

    final Movie x = new Movie("Title", 2000, "Poster");

    @GetMapping("/getAllMovie")
    public ArrayList<Movie> getMovies() {
        listMovies.add(x);
        return listMovies;
    }

    @GetMapping("/searchMovies")
    public ArrayList<Movie> searchMovie(@RequestParam(name = "title", required = false, defaultValue = "") String title, 
            @RequestParam(name = "year", required = false, defaultValue = "0") int year) {
            
            if (year != 0 && title != "") {
                return searchByTitleAndYear(year, title);
            }

            if (year != 0) {
                return searchByYear(year);
            }

            if (title != "") {
                return searchByTitle(title);
            }

            return null;
    }

    private ArrayList<Movie> searchByTitle(String title) {
        ArrayList<Movie> titleMovies = new ArrayList<>();

        for (Movie movie : listMovies) {
            if (title.contains(movie.getTitle())) {
                titleMovies.add(movie);
            }
        }

        return titleMovies;
    }

    private ArrayList<Movie> searchByYear(int year) {
        ArrayList<Movie> yearMovie = new ArrayList<>();

        for (Movie movie : listMovies) {
            if (year == movie.getYear()) {
                yearMovie.add(movie);
            }
        }

        return yearMovie;
    }

    private ArrayList<Movie> searchByTitleAndYear(int year, String title) {
        ArrayList<Movie> movies = new ArrayList<>();

        movies = cloneList(searchByYear(year), movies);
        movies = cloneList(searchByTitle(title), movies);

        return movies;
    }

    private ArrayList<Movie> cloneList(ArrayList<Movie> a, ArrayList<Movie> b) {
        ArrayList<Movie> c = null;

        for (int i = 0; i < a.size(); i++) {
            b.add(a.get(i));
        }

        c = b;

        return c;
    }
}
