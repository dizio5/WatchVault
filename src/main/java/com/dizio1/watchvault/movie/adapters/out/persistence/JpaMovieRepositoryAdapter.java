package com.dizio1.watchvault.movie.adapters.out.persistence;

import com.dizio1.watchvault.movie.application.ports.out.MovieRepository;
import com.dizio1.watchvault.movie.domain.Movie;

import java.util.Optional;

public class JpaMovieRepositoryAdapter implements MovieRepository {

    private final JpaMovieRepository movieRepository;

    public JpaMovieRepositoryAdapter(JpaMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return Optional.empty();
    }
}
