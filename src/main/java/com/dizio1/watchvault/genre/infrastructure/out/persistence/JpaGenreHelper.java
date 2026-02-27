package com.dizio1.watchvault.genre.infrastructure.out.persistence;

import com.dizio1.watchvault.genre.domain.model.Genre;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JpaGenreHelper {

    private final JpaGenreRepository genreRepository;
    private final JpaGenreMapper genreMapper;

    public JpaGenreHelper(JpaGenreRepository genreRepository, JpaGenreMapper genreMapper) {
        this.genreMapper = genreMapper;
        this.genreRepository = genreRepository;
    }

    public Set<GenreEntity> resolveGenres(List<Genre> genres) {
        List<Long> ids = genres.stream()
                .map(Genre::id)
                .toList();

        List<GenreEntity> existingEntities = genreRepository.findAllById(ids);
        List<Long> existingIds = existingEntities.stream()
                .map(GenreEntity::getId)
                .toList();

        List<GenreEntity> newGenres = genres.stream()
                .map(genreMapper::toEntity)
                .filter(genreEntity -> !existingIds.contains(genreEntity.getId()))
                .toList();

        genreRepository.saveAll(newGenres);
        existingEntities.addAll(newGenres);
        return new HashSet<>(existingEntities);
    }
}
