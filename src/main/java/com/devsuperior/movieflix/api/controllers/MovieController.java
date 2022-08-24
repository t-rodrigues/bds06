package com.devsuperior.movieflix.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.domain.dtos.MovieDTO;
import com.devsuperior.movieflix.domain.dtos.View;
import com.devsuperior.movieflix.domain.services.MovieService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService moviceService;

    public MovieController(MovieService moviceService) {
        this.moviceService = moviceService;
    }

    @GetMapping
    public Page<MovieDTO> getMovies(@RequestParam(defaultValue = "0") Long genreId, Pageable pageable) {
        return moviceService.findByGenre(genreId, pageable);
    }

    @JsonView(View.Sumary.class)
    @GetMapping("/{movieId}")
    public MovieDTO getMovieById(@PathVariable Long movieId) {
        return moviceService.findById(movieId);
    }

}
