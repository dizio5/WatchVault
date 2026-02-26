package com.dizio1.watchvault.series.application.ports.out;

import com.dizio1.watchvault.series.domain.model.Series;

import java.util.Optional;

public interface SeriesRepositoryPort {

    Series save(Series series);

    Optional<Series> findByTitle(String title);
}
