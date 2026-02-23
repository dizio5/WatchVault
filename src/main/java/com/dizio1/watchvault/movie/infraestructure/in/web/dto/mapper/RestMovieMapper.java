package com.dizio1.watchvault.movie.infraestructure.in.web.dto.mapper;

import com.dizio1.watchvault.movie.domain.model.Movie;
import com.dizio1.watchvault.movie.infraestructure.in.web.dto.MovieResponse;
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
