package com.dizio1.watchvault.movie.infraestructure.in.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CastResponse(
        String name,
        Boolean adult,
        Integer gender,
        String character
) {
}
