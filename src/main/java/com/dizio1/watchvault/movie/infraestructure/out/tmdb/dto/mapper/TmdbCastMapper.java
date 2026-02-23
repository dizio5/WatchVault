package com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.mapper;

import com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.SearchCastDTO;
import com.dizio1.watchvault.movie.domain.model.CastMember;
import org.springframework.stereotype.Component;

@Component
public class TmdbCastMapper {

    public CastMember toModel(SearchCastDTO response) {
        return new CastMember(
                response.id(),
                response.name(),
                response.adult(),
                response.gender(),
                response.character());
    }
}
