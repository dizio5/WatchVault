package com.dizio1.watchvault.movie.infraestructure.in.web.dto.mapper;

import com.dizio1.watchvault.movie.domain.model.Movie;
import com.dizio1.watchvault.movie.infraestructure.in.web.dto.GenreResponse;
import com.dizio1.watchvault.movie.infraestructure.in.web.dto.MovieResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestMovieMapper {

    private final RestGenreMapper genreMapper;

    public RestMovieMapper(RestGenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }

    public MovieResponse fromModelToResponse(Movie movie) {
        List<GenreResponse> genreResponseList = movie.getGenres()
                .stream()
                .map(genreMapper::toResponse)
                .toList();

        return new MovieResponse(movie.getTitle(),
                movie.getOverview(),
                movie.getDirectedBy(),
                movie.getRuntime(),
                movie.getReleaseDate(),
                movie.isAdult(),
                genreResponseList);
    }
}
