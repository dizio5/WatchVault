package com.dizio1.watchvault.movie.application.usecase;

import com.dizio1.watchvault.movie.application.ports.in.SearchCrewMembersUseCase;
import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.domain.model.CrewMember;

import java.util.List;

public class SearchCrewMembersUseCaseImpl implements SearchCrewMembersUseCase {

    private final MovieCatalogPort movieCatalog;

    public SearchCrewMembersUseCaseImpl(MovieCatalogPort movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    @Override
    public List<CrewMember> getCrewMembers(String name) {
        Long id = movieCatalog.searchMovieId(name);
        return movieCatalog.searchMovieCrewMembers(id);
    }
}
