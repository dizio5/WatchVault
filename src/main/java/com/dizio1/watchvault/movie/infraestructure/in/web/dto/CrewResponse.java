package com.dizio1.watchvault.movie.infraestructure.in.web.dto;

public record CrewResponse(
        String name,
        Boolean adult,
        Integer gender,
        String job,
        String department
) {
}
