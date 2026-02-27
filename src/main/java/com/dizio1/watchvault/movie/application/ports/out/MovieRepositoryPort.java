package com.dizio1.watchvault.movie.application.ports.out;

import com.dizio1.watchvault.movie.domain.model.Movie;

import java.util.Optional;

public interface MovieRepositoryPort {

    Movie registerMovie(Movie movie);

    Optional<Movie> findById(Long id);

    boolean existsById(Long id);
}
