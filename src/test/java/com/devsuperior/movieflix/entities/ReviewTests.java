package com.devsuperior.movieflix.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.devsuperior.movieflix.domain.entities.Movie;
import com.devsuperior.movieflix.domain.entities.Review;
import com.devsuperior.movieflix.domain.entities.User;

public class ReviewTests {

    @Test
    public void reviewShouldHaveCorrectStructure() {

        Review entity = new Review();
        entity.setId(1L);
        entity.setText("Text");
        entity.setMovie(new Movie());
        entity.setUser(new User());

        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getText());
        Assertions.assertNotNull(entity.getMovie());
        Assertions.assertNotNull(entity.getUser());
    }

}
