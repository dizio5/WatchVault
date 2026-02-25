package com.dizio1.watchvault.series.infraestructure.out.tmdb.dto;

import com.dizio1.watchvault.movie.domain.model.Genre;
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
        Integer numberOfEpisodes,
        @JsonProperty("number_of_episodes")
        Integer numberOfSeasons,
        @JsonProperty("first_air_date")
        LocalDate firstAirDate,
        @JsonProperty("last_air_date")
        LocalDate lastAirDate,
        String status,
        boolean adult,
        List<Genre>genres
) {
    public record TmdbCreatorDto(String name) {

    }
}
