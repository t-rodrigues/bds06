package com.devsuperior.movieflix.domain.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devsuperior.movieflix.domain.dtos.MovieDTO;

public interface MovieService {

    Page<MovieDTO> findByGenre(Long genreId, Pageable pageable);

    MovieDTO findById(Long movieId);

}
