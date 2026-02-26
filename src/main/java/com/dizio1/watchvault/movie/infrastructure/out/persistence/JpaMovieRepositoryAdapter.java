package com.dizio1.watchvault.movie.infrastructure.out.persistence;

import com.dizio1.watchvault.movie.application.ports.out.MovieRepositoryPort;
import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaMovieRepositoryAdapter implements MovieRepositoryPort {

    private final JpaMovieRepository movieRepository;
    private final JpaMovieMapper movieMapper;

    public JpaMovieRepositoryAdapter(JpaMovieRepository movieRepository,
                                     JpaMovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public Movie save(Movie movie) {
        MovieEntity entity = movieRepository.save(movieMapper.toEntity(movie));
        return movieMapper.toModel(entity);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id)
                .map(movieMapper::toModel);
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title)
                .map(movieMapper::toModel);
    }
}
