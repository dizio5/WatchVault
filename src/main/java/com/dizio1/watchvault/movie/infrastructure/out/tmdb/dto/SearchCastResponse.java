package com.dizio1.watchvault.movie.infrastructure.out.tmdb.dto;

import java.util.List;

public record SearchCastResponse(
        List<SearchCastDTO> cast
) {
}
