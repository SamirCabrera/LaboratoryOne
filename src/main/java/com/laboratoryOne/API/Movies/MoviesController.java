package com.laboratoryOne.API.Movies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.laboratoryOne.Model.Movie;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
    
    public static List<Movie> listMovies = Arrays.asList(new Movie("Title1", 2001), new Movie("Title2", 2002));

    @GetMapping("/text/movie")
    public String textMovie(Locale local) {
        ResourceBundle messages = ResourceBundle.getBundle("i18n\\movie", local);

        return messages.getString("MOVIE_TITLE");
    }

    @GetMapping("/getAllMovie")
    public List<Movie> getMovies() {
        return listMovies;
    }

    @GetMapping("/searchMovies")
    public List<Movie> searchMovie(@RequestParam(name = "year", required = false, defaultValue = "0") int year, 
    @RequestParam(name = "title", required = false, defaultValue = "") String title) {
            
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

    @PostMapping("/addMovie")
    public void add(@RequestBody Movie newMovie) {
        listMovies.add(new Movie(newMovie.getTitle(), newMovie.getYear()));
    }

    @PutMapping("/updateMovie/{id}")
    public Movie update(@RequestBody Movie movieUpdate, @PathVariable("id") int id) {
            Movie m = new Movie();

            for (Movie movie : listMovies) {
                if (id == movie.getId()) {
                    movie.setTitle(movieUpdate.getTitle());
                    movie.setYear(movieUpdate.getYear());
                    m = movie;
                }
            }
            
            return m;
    }

    @DeleteMapping("/deleteMovie")
    public void delete(@RequestParam(name = "id", required = true, defaultValue = "0") int id) {
        for (Movie movie : listMovies) {
            if (id == movie.getId()) {
                listMovies.remove(movie);
            }
        }
    }

    public static Movie findById(int id) {
        for (Movie movie : listMovies) {
            if (id == movie.getId()) {
                return movie;
            }
        }

        return null;
    }

    private List<Movie> searchByTitle(String title) {
        List<Movie> titleMovies = new ArrayList<>();

        for (Movie movie : listMovies) {
            if (title.contains(movie.getTitle())) {
                titleMovies.add(movie);
            }
        }

        return titleMovies;
    }

    private List<Movie> searchByYear(int year) {
        List<Movie> yearMovie = new ArrayList<>();

        for (Movie movie : listMovies) {
            if (year == movie.getYear()) {
                yearMovie.add(movie);
            }
        }

        return yearMovie;
    }

    private List<Movie> searchByTitleAndYear(int year, String title) {
        List<Movie> movies = new ArrayList<>();

        movies = cloneList(searchByYear(year), movies);
        movies = cloneList(searchByTitle(title), movies);

        return movies;
    }

    private List<Movie> cloneList(List<Movie> a, List<Movie> b) {
        List<Movie> c = null;

        for (int i = 0; i < a.size(); i++) {
            b.add(a.get(i));
        }

        c = b;

        return c;
    }
}
