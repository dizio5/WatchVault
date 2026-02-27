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
        movie.setDirectedBy(movieEntity.getDirectedBy());
        movie.setGenres(movieEntity.getGenres()
                .stream()
                .map(genreMapper::toModel)
                .toList());
        movie.setOverview(movieEntity.getOverview());
        movie.setRuntime(movieEntity.getRuntime());
        movie.setReleaseDate(movieEntity.getReleaseDate());
        return movie;
    }

    public MovieEntity toEntity(Movie movie) {
        MovieEntity entity = new MovieEntity();
        entity.setId(movie.getId());
        entity.setTitle(movie.getTitle());
        entity.setOverview(movie.getOverview());
        entity.setDirectedBy(movie.getDirectedBy());
        entity.setRuntime(movie.getRuntime());
        entity.setReleaseDate(movie.getReleaseDate());
        return entity;
    }
}
