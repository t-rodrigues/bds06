package com.devsuperior.movieflix.domain.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.domain.dtos.GenreDTO;
import com.devsuperior.movieflix.domain.services.GenreService;
import com.devsuperior.movieflix.infra.repositories.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<GenreDTO> findAll() {
        return genreRepository.findAll().stream().map(GenreDTO::new).collect(Collectors.toList());
    }

}
