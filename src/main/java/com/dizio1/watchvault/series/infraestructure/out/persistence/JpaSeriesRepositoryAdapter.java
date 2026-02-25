package com.dizio1.watchvault.series.infraestructure.out.persistence;

import com.dizio1.watchvault.series.application.ports.out.SeriesRepositoryPort;
import com.dizio1.watchvault.series.domain.model.Series;
import org.springframework.stereotype.Component;

@Component
public class JpaSeriesRepositoryAdapter implements SeriesRepositoryPort {

    private final JpaSeriesRepository seriesRepository;
    private final JpaSeriesMapper seriesMapper;

    public JpaSeriesRepositoryAdapter(JpaSeriesRepository seriesRepository, JpaSeriesMapper seriesMapper) {
        this.seriesRepository = seriesRepository;
        this.seriesMapper = seriesMapper;
    }

    @Override
    public Series save(Series series) {
        SeriesEntity seriesEntity = seriesRepository.save(seriesMapper.toEntity(series));
        return seriesMapper.toModel(seriesEntity);
    }
}
