package com.devsuperior.movieflix.domain.dtos;

import com.fasterxml.jackson.annotation.JsonView;

public class ReviewDTO {

    @JsonView({ View.Sumary.class })
    private Long id;
    @JsonView({ View.Create.class, View.Sumary.class })
    private String text;
    @JsonView({ View.Create.class, View.Sumary.class })
    private Long movieId;

    @JsonView({ View.Sumary.class })
    private UserDTO user;

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
