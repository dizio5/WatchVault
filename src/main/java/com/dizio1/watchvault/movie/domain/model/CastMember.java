package com.dizio1.watchvault.movie.domain.model;

public record CastMember(
        Long id,
        String name,
        Integer gender,
        String character
) {
}
