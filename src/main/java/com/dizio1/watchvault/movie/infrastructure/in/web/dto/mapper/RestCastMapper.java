package com.dizio1.watchvault.movie.infrastructure.in.web.dto.mapper;

import com.dizio1.watchvault.movie.domain.model.CastMember;
import com.dizio1.watchvault.movie.infrastructure.in.web.dto.CastResponse;
import org.springframework.stereotype.Component;

@Component
public class RestCastMapper {

    public CastResponse toResponse(CastMember castMember) {
        return new CastResponse(castMember.name(),
                castMember.gender(),
                castMember.character());
    }
}
