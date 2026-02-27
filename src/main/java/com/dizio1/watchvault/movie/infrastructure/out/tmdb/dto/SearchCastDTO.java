package com.dizio1.watchvault.movie.infrastructure.out.tmdb.dto;

public record SearchCastDTO(
        Long id,
        String name,
        Integer gender,
        String character,
        Integer order,
        Double popularity
) {
}
