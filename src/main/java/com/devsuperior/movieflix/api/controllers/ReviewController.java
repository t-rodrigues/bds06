package com.devsuperior.movieflix.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.movieflix.domain.dtos.ReviewDTO;
import com.devsuperior.movieflix.domain.dtos.View;
import com.devsuperior.movieflix.domain.services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@RequestBody @Validated(View.Create.class) ReviewDTO reviewDTO) {
        var review = reviewService.insert(reviewDTO);
        var location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{reviewId}")
                .buildAndExpand(review.getId()).toUri();
        return ResponseEntity.created(location).body(review);
    }

}
