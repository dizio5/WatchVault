package com.dizio1.watchvault.movie.application.usecase;

import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.domain.model.Movie;

import java.util.Optional;

public class SearchMovieUseCaseImpl implements SearchMovieUseCase {

    private final MovieCatalogPort movieCatalog;

    public SearchMovieUseCaseImpl(MovieCatalogPort movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    @Override
    public Movie getMovieDetails(String name) {
        Long movieId = movieCatalog.searchMovieId(name);

        CrewMember director = getMovieDirector(movieId)
                .orElseThrow(() -> new IllegalStateException("Director not found"));

        Movie movie = movieCatalog.getMovieDetails(movieId);
        movie.setDirectedBy(director.name());
        return movie;
    }

    private Optional<CrewMember> getMovieDirector(Long id) {
        return movieCatalog.searchMovieCrewMembers(id)
                .stream()
                .filter(crewMember -> crewMember.job().equals("Director"))
                .findFirst();
    }
}
