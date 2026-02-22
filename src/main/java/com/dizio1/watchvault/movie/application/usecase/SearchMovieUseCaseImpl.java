package com.dizio1.watchvault.movie.application.usecase;

import com.dizio1.watchvault.movie.infraestructure.out.tmdb.TmdbMovieCatalogAdapter;
import com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.MovieId;
import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchMovieUseCaseImpl implements SearchMovieUseCase {

    private final TmdbMovieCatalogAdapter tmdbMovieCatalogAdapter;

    public SearchMovieUseCaseImpl(TmdbMovieCatalogAdapter tmdbMovieCatalogAdapter) {
        this.tmdbMovieCatalogAdapter = tmdbMovieCatalogAdapter;
    }

    @Override
    public Movie getMovieDetails(String name) {
        MovieId movieId = tmdbMovieCatalogAdapter.searchMovieId(name).results().getFirst();

        CrewMember director = getMovieDirector(movieId.id())
                .orElseThrow(() -> new IllegalStateException("Director not found"));

        Movie movie = tmdbMovieCatalogAdapter.getMovieDetails(movieId.id());
        movie.setDirectedBy(director.name());
        return movie;
    }

    private Optional<CrewMember> getMovieDirector(Long id) {
        return tmdbMovieCatalogAdapter.searchMovieCrewMembers(id)
                .stream()
                .filter(crewMember -> crewMember.job().equals("Director"))
                .findFirst();
    }
}
