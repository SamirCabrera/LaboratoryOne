package com.laboratoryOne.API.Movies;

import com.laboratoryOne.Model.Movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoviesViewController {
    @GetMapping("/movies")
    public ModelAndView MovieView() {
        ModelAndView mv = new ModelAndView("movie");
        mv.addObject("movies", MoviesController.listMovies);

        return mv;
    }

    @PostMapping("/search")
    public ModelAndView searchMovie(@ModelAttribute(value="modelMovie") Movie movie) {
        ModelAndView mv = new ModelAndView("movie");
        mv.addObject("findMovies", MoviesController.searchMovie(2000, "Title1"));

        return mv;
    }

}
