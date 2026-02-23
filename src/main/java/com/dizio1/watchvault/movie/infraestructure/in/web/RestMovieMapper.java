package com.dizio1.watchvault.movie.infraestructure.in.web;

import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class RestMovieMapper {

    public MovieResponse fromModelToResponse(Movie movie) {
        return new MovieResponse(movie.getTitle(),
                movie.getOverview(),
                movie.getDirectedBy(),
                movie.getRuntime(),
                movie.getReleaseDate(),
                movie.isAdult(),
                movie.getGenres());
    }
}
