package com.dizio1.watchvault.series.application.usecase;

import com.dizio1.watchvault.series.application.ports.in.SaveSeriesUseCase;
import com.dizio1.watchvault.series.application.ports.out.SeriesRepositoryPort;
import com.dizio1.watchvault.series.domain.model.Series;

public class SaveSeriesUseCaseImpl implements SaveSeriesUseCase {

    private final SeriesRepositoryPort seriesRepository;

    public SaveSeriesUseCaseImpl(SeriesRepositoryPort seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public Series saveSeries(Series series) {
        return seriesRepository.save(series);
    }
}
