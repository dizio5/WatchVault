package com.dizio1.watchvault.movie.infraestructure.in.web.dto;

public record CastResponse(
        String name,
        Boolean adult,
        Integer gender,
        String character
) {
}
