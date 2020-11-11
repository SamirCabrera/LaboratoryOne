package com.laboratoryOne.API.Movies;

import com.laboratoryOne.Model.Movie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoviesViewController {
    @GetMapping("/movies")
    public ModelAndView MovieView() {
        ModelAndView mv = new ModelAndView("movie");
        mv.addObject("movies", MoviesController.listMovies);

        return mv;
    }

    @PostMapping("/add")
    public String add(@RequestBody Movie newMovie) {
        MoviesController.listMovies.add(new Movie(newMovie.getTitle(), newMovie.getYear(), newMovie.getImgPoster()));
        return "redirect:/movies";
    }
}
