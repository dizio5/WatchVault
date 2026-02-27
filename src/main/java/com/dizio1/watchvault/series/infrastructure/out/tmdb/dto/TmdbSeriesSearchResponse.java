package com.dizio1.watchvault.series.infrastructure.out.tmdb.dto;

import com.dizio1.watchvault.genre.domain.model.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record TmdbSeriesSearchResponse(
        Long id,
        String name,
        String overview,
        @JsonProperty("created_by")
        List<TmdbCreatorDto> createdBy,
        @JsonProperty("number_of_seasons")
        Integer numberOfSeasons,
        @JsonProperty("number_of_episodes")
        Integer numberOfEpisodes,
        @JsonProperty("first_air_date")
        LocalDate firstAirDate,
        @JsonProperty("last_air_date")
        LocalDate lastAirDate,
        String status,
        List<Genre> genres
) {
    public record TmdbCreatorDto(String name) {

    }
}
