package com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto;

import java.util.List;

public record SearchCastResponse(
        List<SearchCastDTO> cast
) {
}
