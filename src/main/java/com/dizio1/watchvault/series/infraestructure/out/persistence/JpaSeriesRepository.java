package com.dizio1.watchvault.series.infraestructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSeriesRepository extends JpaRepository<SeriesEntity, Long> {
}
