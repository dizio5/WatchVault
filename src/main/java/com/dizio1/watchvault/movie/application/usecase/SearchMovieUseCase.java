package com.dizio1.watchvault.movie.application.usecase;

import com.dizio1.watchvault.movie.adapters.out.dto.MovieId;

public interface SearchMovieUseCase {

    MovieId getMovieId(String name);
}
