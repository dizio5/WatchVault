package com.dizio1.watchvault.genre.infraestructure.in.web.dto;

import com.dizio1.watchvault.genre.domain.Genre;
import org.springframework.stereotype.Component;

@Component
public class RestGenreMapper {

    public GenreResponse toResponse(Genre genre) {
        return new GenreResponse(genre.name());
    }
}
