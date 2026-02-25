package com.dizio1.watchvault.series.application.ports.in;

import com.dizio1.watchvault.series.domain.model.Series;

public interface SearchSeriesUseCase {

    Series searchByTitle(String title);
}
