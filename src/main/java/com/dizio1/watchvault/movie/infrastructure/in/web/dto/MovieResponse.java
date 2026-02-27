package com.dizio1.watchvault.movie.infrastructure.in.web.dto;

import com.dizio1.watchvault.genre.infrastructure.in.web.dto.GenreResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MovieResponse(
        String title,
        String overview,
        String directedBy,
        int runtime,
        LocalDate releaseDate,
        List<GenreResponse> genres
) {
}
