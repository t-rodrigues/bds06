package com.devsuperior.movieflix.domain.dtos;

import com.devsuperior.movieflix.domain.entities.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @JsonView({ View.Sumary.class })
    private Long id;
    @JsonView({ View.Create.class, View.Sumary.class })
    private String name;
    @JsonView({ View.Create.class, View.Sumary.class })
    private String email;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
