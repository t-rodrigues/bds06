package com.devsuperior.movieflix.domain.dtos;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.domain.entities.Genre;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenreDTO {

    @JsonView({ View.Sumary.class })
    private Long id;

    @NotBlank
    @JsonView({ View.Create.class, View.Sumary.class })
    private String name;

    public GenreDTO() {
    }

    public GenreDTO(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
