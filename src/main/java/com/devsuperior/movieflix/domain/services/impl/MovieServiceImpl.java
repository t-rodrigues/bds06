package com.devsuperior.movieflix.domain.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.domain.dtos.MovieDTO;
import com.devsuperior.movieflix.domain.services.MovieService;
import com.devsuperior.movieflix.domain.services.exceptions.NotFoundException;
import com.devsuperior.movieflix.infra.repositories.GenreRepository;
import com.devsuperior.movieflix.infra.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Page<MovieDTO> findByGenre(Long genreId, Pageable pageable) {
        var genre = genreId > 0 ? genreRepository.getOne(genreId) : null;
        return movieRepository.search(genre, pageable).map(MovieDTO::new);
    }

    @Override
    public MovieDTO findById(Long movieId) {
        var movie = movieRepository.findByIdWithGenre(movieId)
                .orElseThrow(() -> new NotFoundException("movie not found: " + movieId));
        return new MovieDTO(movie);
    }

}
