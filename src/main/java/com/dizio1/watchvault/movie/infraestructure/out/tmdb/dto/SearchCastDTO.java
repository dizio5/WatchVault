package com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto;

public record SearchCastDTO(
        Long id,
        String name,
        Integer adult,
        Integer gender,
        String character,
        Integer order,
        Double popularity
) {
}
