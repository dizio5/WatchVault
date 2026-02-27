package com.dizio1.watchvault.movie.infrastructure.out.tmdb.dto;

import com.dizio1.watchvault.genre.domain.model.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record TmdbMovieResponse(
        Long id,
        @JsonProperty("original_title")
        String originalTitle,
        String overview,
        int runtime,
        @JsonProperty("release_date")
        LocalDate releaseDate,
        List<Genre> genres
) {
}
