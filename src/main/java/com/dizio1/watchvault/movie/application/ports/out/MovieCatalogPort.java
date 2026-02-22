package com.dizio1.watchvault.movie.application.ports.out;

import com.dizio1.watchvault.movie.adapters.out.tmdb.dto.SearchMoviesIdResult;
import com.dizio1.watchvault.movie.domain.Movie;

public interface MovieCatalogPort {

    SearchMoviesIdResult searchMovieId(String query);
    Movie getMovieDetails(Long id);
}
