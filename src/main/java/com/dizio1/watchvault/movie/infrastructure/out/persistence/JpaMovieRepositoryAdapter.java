package com.dizio1.watchvault.movie.infrastructure.out.persistence;

import com.dizio1.watchvault.genre.infrastructure.out.persistence.JpaGenreHelper;
import com.dizio1.watchvault.movie.application.ports.out.MovieRepositoryPort;
import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaMovieRepositoryAdapter implements MovieRepositoryPort {

    private final JpaMovieRepository movieRepository;
    private final JpaMovieMapper movieMapper;
    private final JpaGenreHelper genreHelper;

    public JpaMovieRepositoryAdapter(JpaMovieRepository movieRepository,
                                     JpaMovieMapper movieMapper,
                                     JpaGenreHelper genreHelper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.genreHelper = genreHelper;
    }

    @Override
    public Movie registerMovie(Movie movie) {
        MovieEntity entity = movieMapper.toEntity(movie);
        entity.setGenres(genreHelper.resolveGenres(movie.getGenres()));
        MovieEntity saved = movieRepository.save(entity);
        return movieMapper.toModel(saved);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id)
                .map(movieMapper::toModel);
    }

    @Override
    public boolean existsById(Long id) {
        return movieRepository.existsById(id);
    }
}
