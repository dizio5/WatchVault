package com.dizio1.watchvault.genre.infrastructure.in.web.dto;

import com.dizio1.watchvault.genre.domain.model.Genre;
import org.springframework.stereotype.Component;

@Component
public class RestGenreMapper {

    public GenreResponse toResponse(Genre genre) {
        return new GenreResponse(genre.name());
    }
}
