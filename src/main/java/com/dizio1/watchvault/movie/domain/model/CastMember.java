package com.dizio1.watchvault.movie.domain.model;

public record CastMember(
        Long id,
        String name,
        Boolean adult,
        Integer gender,
        String character
) {
}
