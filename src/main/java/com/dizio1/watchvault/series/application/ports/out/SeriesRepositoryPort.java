package com.dizio1.watchvault.series.application.ports.out;

import com.dizio1.watchvault.series.domain.model.Series;

public interface SeriesRepositoryPort {

    Series save(Series series);
}
