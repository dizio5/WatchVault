package com.dizio1.watchvault.series.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaSeriesRepository extends JpaRepository<SeriesEntity, Long> {

    Optional<SeriesEntity> findByTitle(String title);
}
