package com.dizio1.watchvault.movie.infrastructure.in.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CastResponse(
        String name,
        Integer gender,
        String character
) {
}
