package com.devsuperior.movieflix.infra.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.domain.entities.Genre;
import com.devsuperior.movieflix.domain.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m JOIN FETCH m.genre WHERE m.id = :movieId")
    Optional<Movie> findByIdWithGenre(Long movieId);

    @Query("SELECT m FROM Movie m WHERE :genre IS NULL OR m.genre = :genre ORDER BY m.title")
    Page<Movie> search(Genre genre, Pageable pageable);

}
