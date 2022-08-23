package com.devsuperior.movieflix.infra.security.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.domain.entities.User;
import com.devsuperior.movieflix.infra.repositories.UserRepository;
import com.devsuperior.movieflix.infra.security.AuthService;
import com.devsuperior.movieflix.infra.security.authorizations.SelfOrAdmin;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getAuthenticated() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userRepository.findByEmail(authentication.getName()).orElseThrow();
        validateSelfOrAdmin(user.getId());
        return user;
    }

    @SelfOrAdmin
    private void validateSelfOrAdmin(Long userId) {

    }

}
