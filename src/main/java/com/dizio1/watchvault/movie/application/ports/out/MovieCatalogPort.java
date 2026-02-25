package com.dizio1.watchvault.movie.application.ports.out;

import com.dizio1.watchvault.movie.domain.model.CastMember;
import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.domain.model.Movie;

import java.util.List;

public interface MovieCatalogPort {

    Movie searchByTitle(String title);
    List<CastMember> searchCastMembers(String title);
    List<CrewMember> searchCrewMembers(String title);
}
