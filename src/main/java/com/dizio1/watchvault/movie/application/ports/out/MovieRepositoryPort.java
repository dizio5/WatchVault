package com.dizio1.watchvault.movie.application.ports.out;

import com.dizio1.watchvault.movie.domain.model.Movie;

public interface MovieRepositoryPort {

    Movie registerMovie(Movie movie);

    boolean existsById(Long id);
}
