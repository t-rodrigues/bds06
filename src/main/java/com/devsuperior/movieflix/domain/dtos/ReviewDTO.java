package com.devsuperior.movieflix.domain.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.devsuperior.movieflix.domain.entities.Review;
import com.fasterxml.jackson.annotation.JsonView;

public class ReviewDTO {

    @JsonView({ View.Sumary.class })
    private Long id;

    @NotBlank(groups = View.Create.class)
    @JsonView({ View.Create.class, View.Sumary.class })
    private String text;

    @NotNull(groups = View.Create.class)
    @JsonView({ View.Create.class, View.Sumary.class })
    private Long movieId;

    @JsonView({ View.Sumary.class })
    private UserDTO user;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.text = review.getText();
        this.movieId = review.getMovie().getId();
        this.user = new UserDTO(review.getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

}
