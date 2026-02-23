package com.dizio1.watchvault.movie.infraestructure.out.persistence;

import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaMovieRepository extends JpaRepository<MovieEntity, Long> {

    MovieEntity save(Movie movie);
    Optional<MovieEntity> findById(Long id);
    Optional<MovieEntity> findByOriginalTitle(String title);
}
