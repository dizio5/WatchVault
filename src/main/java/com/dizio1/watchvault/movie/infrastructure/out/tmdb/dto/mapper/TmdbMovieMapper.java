package com.dizio1.watchvault.movie.infrastructure.out.tmdb.dto.mapper;

import com.dizio1.watchvault.movie.domain.model.Movie;
import com.dizio1.watchvault.movie.infrastructure.out.tmdb.dto.TmdbMovieResponse;
import org.springframework.stereotype.Component;

@Component
public class TmdbMovieMapper {

    public Movie toModel(TmdbMovieResponse response) {
        Movie movie = new Movie();
        movie.setTitle(response.originalTitle());
        movie.setAdult(response.adult());
        movie.setGenres(response.genres());
        movie.setOverview(response.overview());
        movie.setRuntime(response.runtime());
        movie.setId(response.id());
        movie.setReleaseDate(response.releaseDate());
        return movie;
    }
}
