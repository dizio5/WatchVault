package com.dizio1.watchvault.series.application.usecase;

import com.dizio1.watchvault.series.application.ports.in.SearchSeriesUseCase;
import com.dizio1.watchvault.series.application.ports.out.SeriesCatalogPort;
import com.dizio1.watchvault.series.domain.model.Series;

public class SearchSeriesUseCaseImpl implements SearchSeriesUseCase {

    private final SeriesCatalogPort seriesCatalog;

    public SearchSeriesUseCaseImpl(SeriesCatalogPort seriesCatalog) {
        this.seriesCatalog = seriesCatalog;
    }

    @Override
    public Series searchByTitle(String title) {
        return seriesCatalog.searchByTitle(title);
    }
}
