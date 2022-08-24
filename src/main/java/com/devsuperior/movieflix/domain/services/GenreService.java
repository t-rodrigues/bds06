package com.devsuperior.movieflix.domain.services;

import java.util.List;

import com.devsuperior.movieflix.domain.dtos.GenreDTO;

public interface GenreService {

    List<GenreDTO> findAll();

}
