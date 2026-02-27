package com.dizio1.watchvault.movie.domain.model;

public record CrewMember(
        Long id,
        String name,
        Integer gender,
        String job,
        String department
) {
}
