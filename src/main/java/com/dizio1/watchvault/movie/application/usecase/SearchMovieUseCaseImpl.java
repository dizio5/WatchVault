package com.dizio1.watchvault.movie.application.usecase;

import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.domain.model.Movie;

public class SearchMovieUseCaseImpl implements SearchMovieUseCase {

    private final MovieCatalogPort movieCatalog;

    public SearchMovieUseCaseImpl(MovieCatalogPort movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    @Override
    public Movie searchMovie(String title) {
        String director = getMovieDirector(title);

        Movie movie = movieCatalog.searchByTitle(title);
        movie.setDirectedBy(director);
        return movie;
    }

    private String getMovieDirector(String title) {
        return movieCatalog.searchCrewMembers(title)
                .stream()
                .filter(CrewMember -> CrewMember.job().equals("Director"))
                .findFirst()
                .map(CrewMember::name)
                .orElse(null);
    }
}
