package com.dizio1.watchvault.movie.application.ports.out;

import com.dizio1.watchvault.movie.domain.model.Movie;

import java.util.Optional;

public interface MovieRepository {

    Movie save(Movie movie);
    Optional<Movie> findById(Long id);
    Optional<Movie> findByTitle(String title);
}
