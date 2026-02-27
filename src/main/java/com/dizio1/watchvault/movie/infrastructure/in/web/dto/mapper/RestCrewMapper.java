package com.dizio1.watchvault.movie.infrastructure.in.web.dto.mapper;

import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.infrastructure.in.web.dto.CrewResponse;
import org.springframework.stereotype.Component;

@Component
public class RestCrewMapper {

    public CrewResponse toResponse(CrewMember crewMember) {
        return new CrewResponse(crewMember.name(),
                crewMember.adult(),
                crewMember.gender(),
                crewMember.job(),
                crewMember.department());
    }
}
