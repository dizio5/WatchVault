package com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto;

import java.util.List;

public record SearchMoviesIdResponse(List<MovieId> results) {
    public record MovieId(Long id) {

    }
}
