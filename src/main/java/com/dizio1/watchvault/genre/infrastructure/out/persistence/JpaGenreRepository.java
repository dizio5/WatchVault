package com.dizio1.watchvault.genre.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGenreRepository extends JpaRepository<GenreEntity, Long> {
}
