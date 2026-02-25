package com.dizio1.watchvault.movie.application.usecase;

import com.dizio1.watchvault.movie.application.ports.in.SearchCastMembersUseCase;
import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.domain.model.CastMember;

import java.util.List;

public class SearchCastMembersUseCaseImpl implements SearchCastMembersUseCase {

    private final MovieCatalogPort movieCatalog;

    public SearchCastMembersUseCaseImpl(MovieCatalogPort movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    @Override
    public List<CastMember> getCastMembers(String title) {
        return movieCatalog.searchCastMembers(title);
    }
}
