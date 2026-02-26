package com.dizio1.watchvault.movie.infraestructure.out.persistence;

import com.dizio1.watchvault.genre.domain.Genre;
import org.springframework.stereotype.Component;

@Component
public class JpaGenreMapper {

    public GenreEntity toEntity(Genre genre) {
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setId(genre.id());
        genreEntity.setName(genre.name());
        return genreEntity;
    }

    public Genre toModel(GenreEntity genreEntity) {
        return new Genre(genreEntity.getId(), genreEntity.getName());
    }
}
