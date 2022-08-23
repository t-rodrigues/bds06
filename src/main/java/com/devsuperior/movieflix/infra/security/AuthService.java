package com.devsuperior.movieflix.infra.security;

import com.devsuperior.movieflix.domain.entities.User;

public interface AuthService {

    User getAuthenticated();

}
