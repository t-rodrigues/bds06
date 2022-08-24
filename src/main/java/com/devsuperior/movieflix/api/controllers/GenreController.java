package com.devsuperior.movieflix.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.domain.dtos.GenreDTO;
import com.devsuperior.movieflix.domain.dtos.View;
import com.devsuperior.movieflix.domain.services.GenreService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @JsonView(View.Sumary.class)
    @GetMapping
    public List<GenreDTO> getGenres() {
        return genreService.findAll();
    }

    @PostMapping
    public GenreDTO createGenre(@RequestBody @Valid GenreDTO genreDTO) {
        return null;
    }

}
