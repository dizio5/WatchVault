package com.dizio1.watchvault.movie.infrastructure.out.persistence;

import com.dizio1.watchvault.genre.infrastructure.out.persistence.JpaGenreMapper;
import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class JpaMovieMapper {

    private final JpaGenreMapper genreMapper;

    public JpaMovieMapper(JpaGenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }

    public Movie toModel(MovieEntity movieEntity) {
        Movie movie = new Movie();
        movie.setId(movieEntity.getId());
        movie.setTitle(movieEntity.getTitle());
        movie.setAdult(movieEntity.getAdult());
        movie.setDirectedBy(movieEntity.getDirectedBy());
        movie.setGenres(movieEntity.getGenres()
                .stream()
                .map(genreMapper::toModel)
                .toList());
        movie.setOverview(movie.getOverview());
        movie.setRuntime(movieEntity.getRuntime());
        movie.setReleaseDate(movieEntity.getReleaseDate());
        return movie;
    }
}
