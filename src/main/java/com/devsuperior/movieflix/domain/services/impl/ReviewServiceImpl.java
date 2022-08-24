package com.devsuperior.movieflix.domain.services.impl;

import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.domain.dtos.ReviewDTO;
import com.devsuperior.movieflix.domain.entities.Review;
import com.devsuperior.movieflix.domain.services.ReviewService;
import com.devsuperior.movieflix.infra.repositories.MovieRepository;
import com.devsuperior.movieflix.infra.repositories.ReviewRepository;
import com.devsuperior.movieflix.infra.security.AuthService;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final AuthService authService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, MovieRepository movieRepository,
            AuthService authService) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
        this.authService = authService;
    }

    @Override
    public ReviewDTO insert(ReviewDTO reviewDTO) {
        var movie = movieRepository.getOne(reviewDTO.getMovieId());
        var user = authService.getAuthenticated();
        var review = new Review(null, reviewDTO.getText(), user, movie);
        reviewRepository.save(review);
        return new ReviewDTO(review);
    }

}
