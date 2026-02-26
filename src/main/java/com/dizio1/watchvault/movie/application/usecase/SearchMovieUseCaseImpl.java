package com.dizio1.watchvault.movie.application.usecase;

import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.domain.model.Movie;

import java.util.Optional;

public class SearchMovieUseCaseImpl implements SearchMovieUseCase {

    private final MovieCatalogPort movieCatalog;

    public SearchMovieUseCaseImpl(MovieCatalogPort movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    @Override
    public Movie searchMovie(String title) {
        CrewMember director = getMovieDirector(title)
                .orElseThrow(() -> new IllegalStateException("Director not found"));

        Movie movie = movieCatalog.searchByTitle(title);
        movie.setDirectedBy(director.name());
        return movie;
    }

    private Optional<CrewMember> getMovieDirector(String title) {
        return movieCatalog.searchCrewMembers(title)
                .stream()
                .filter(crewMember -> crewMember.job().equals("Director"))
                .findFirst();
    }
}
