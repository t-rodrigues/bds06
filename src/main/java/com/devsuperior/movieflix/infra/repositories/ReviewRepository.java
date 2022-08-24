package com.devsuperior.movieflix.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.domain.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
