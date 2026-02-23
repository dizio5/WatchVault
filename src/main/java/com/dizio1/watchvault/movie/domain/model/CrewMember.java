package com.dizio1.watchvault.movie.domain.model;

public record CrewMember(
        Long id,
        String name,
        Boolean adult,
        Integer gender,
        String job,
        String department
) {
}
