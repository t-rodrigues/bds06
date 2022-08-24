package com.devsuperior.movieflix.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.domain.dtos.UserDTO;
import com.devsuperior.movieflix.domain.dtos.View;
import com.devsuperior.movieflix.infra.security.AuthService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/users")
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @JsonView(View.Sumary.class)
    @GetMapping("/profile")
    public UserDTO profile() {
        var user = authService.getAuthenticated();
        return new UserDTO(user);
    }

}
