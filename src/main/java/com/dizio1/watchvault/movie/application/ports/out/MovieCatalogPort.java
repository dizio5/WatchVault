package com.dizio1.watchvault.movie.application.ports.out;

import com.dizio1.watchvault.movie.domain.model.CastMember;
import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.domain.model.Movie;

import java.util.List;

public interface MovieCatalogPort {

    Long searchMovieId(String query);
    Movie getMovieDetails(Long id);
    List<CastMember> searchMovieCastMembers(Long id);
    List<CrewMember> searchMovieCrewMembers(Long id);
}
