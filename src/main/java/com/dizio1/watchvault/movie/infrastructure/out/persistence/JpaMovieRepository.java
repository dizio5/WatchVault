package com.dizio1.watchvault.movie.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaMovieRepository extends JpaRepository<MovieEntity, Long> {

    Optional<MovieEntity> findByTitle(String title);
}
