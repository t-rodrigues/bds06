package com.devsuperior.movieflix.domain.dtos;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.domain.entities.Movie;
import com.fasterxml.jackson.annotation.JsonView;

public class MovieDTO {

    @JsonView({ View.Sumary.class })
    private Long id;

    @NotBlank
    @JsonView({ View.Create.class, View.Sumary.class })
    private String title;

    @JsonView({ View.Create.class, View.Sumary.class })
    private String subTitle;

    @JsonView({ View.Create.class, View.Sumary.class })
    private Integer year;

    @JsonView({ View.Create.class, View.Sumary.class })
    private String imgUrl;

    @JsonView({ View.Create.class, View.Sumary.class })
    private String synopsis;

    @JsonView({ View.Sumary.class })
    private GenreDTO genre;

    public MovieDTO() {
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.subTitle = movie.getSubTitle();
        this.year = movie.getYear();
        this.imgUrl = movie.getImgUrl();
        this.synopsis = movie.getSynopsis();
        this.genre = new GenreDTO(movie.getGenre());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

}
