package com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.mapper;

import com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.TmdbMovieResponse;
import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie fromResponseToModel(TmdbMovieResponse response) {
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
