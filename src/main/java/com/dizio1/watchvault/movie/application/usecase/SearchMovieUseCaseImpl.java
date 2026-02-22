package com.dizio1.watchvault.movie.application.usecase;

import com.dizio1.watchvault.movie.adapters.out.tmdb.TmdbMovieCatalogAdapter;
import com.dizio1.watchvault.movie.adapters.out.tmdb.dto.MovieId;
import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.domain.Movie;
import org.springframework.stereotype.Service;

@Service
public class SearchMovieUseCaseImpl implements SearchMovieUseCase {

    private final TmdbMovieCatalogAdapter tmdbMovieCatalogAdapter;

    public SearchMovieUseCaseImpl(TmdbMovieCatalogAdapter tmdbMovieCatalogAdapter) {
        this.tmdbMovieCatalogAdapter = tmdbMovieCatalogAdapter;
    }

    @Override
    public Movie getMovieDetails(String name) {
        MovieId movieId = tmdbMovieCatalogAdapter.searchMovieId(name).results().getFirst();
        return tmdbMovieCatalogAdapter.getMovieDetails(movieId.id());
    }
}
