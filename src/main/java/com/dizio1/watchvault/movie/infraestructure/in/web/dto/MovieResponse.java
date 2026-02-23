package com.dizio1.watchvault.movie.infraestructure.in.web.dto;

import com.dizio1.watchvault.movie.domain.model.Genre;

import java.time.LocalDate;
import java.util.List;

public record MovieResponse(
        String title,
        String overview,
        String directedBy,
        int runtime,
        LocalDate releaseDate,
        boolean adult,
        List<Genre>genres
) {
}
