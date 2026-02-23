package com.dizio1.watchvault.movie.application.ports.in;

import com.dizio1.watchvault.movie.domain.model.Movie;

public interface SearchMovieUseCase {

    Movie getMovieDetails(String name);
}
