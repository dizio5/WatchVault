package com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto;

import com.dizio1.watchvault.movie.domain.model.CrewMember;

import java.util.List;

public record SearchCrewResponse(
        List<CrewMember> crew
) {
}
