package com.dizio1.watchvault.movie.infraestructure.in.web.dto.mapper;

import com.dizio1.watchvault.genre.domain.Genre;
import com.dizio1.watchvault.genre.infraestructure.in.web.dto.GenreResponse;
import org.springframework.stereotype.Component;

@Component
public class RestGenreMapper {

    public GenreResponse toResponse(Genre genre) {
        return new GenreResponse(genre.name());
    }
}
