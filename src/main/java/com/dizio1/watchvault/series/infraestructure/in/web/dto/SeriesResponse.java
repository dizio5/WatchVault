package com.dizio1.watchvault.series.infraestructure.in.web.dto;

import com.dizio1.watchvault.movie.infraestructure.in.web.dto.GenreResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SeriesResponse(
        String title,
        String description,
        String createdBy,
        Integer episodes,
        Integer seasons,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate firstAirDate,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate lastAirDate,
        String status,
        boolean adult,
        List<GenreResponse>genres
) {
}
