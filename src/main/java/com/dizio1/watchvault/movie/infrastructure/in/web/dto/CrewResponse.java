package com.dizio1.watchvault.movie.infrastructure.in.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CrewResponse(
        String name,
        Boolean adult,
        Integer gender,
        String job,
        String department
) {
}
