package com.laboratoryOne.API.Movies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoviesViewController {
    @GetMapping("/movies")
    public ModelAndView MovieView() {
        ModelAndView mv = new ModelAndView("movie");
        mv.addObject("movies", MoviesController.listMovies);

        return mv;
    }
}
