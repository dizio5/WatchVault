package com.dizio1.watchvault.series.infrastructure.out.persistence;

import com.dizio1.watchvault.genre.infrastructure.out.persistence.JpaGenreHelper;
import com.dizio1.watchvault.series.application.ports.out.SeriesRepositoryPort;
import com.dizio1.watchvault.series.domain.model.Series;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaSeriesRepositoryAdapter implements SeriesRepositoryPort {

    private final JpaSeriesRepository seriesRepository;
    private final JpaSeriesMapper seriesMapper;
    private final JpaGenreHelper genreHelper;

    public JpaSeriesRepositoryAdapter(JpaSeriesRepository seriesRepository,
                                      JpaSeriesMapper seriesMapper,
                                      JpaGenreHelper genreHelper) {
        this.seriesRepository = seriesRepository;
        this.seriesMapper = seriesMapper;
        this.genreHelper = genreHelper;
    }

    @Override
    public Series registerSeries(Series series) {
        SeriesEntity entity = seriesMapper.toEntity(series);
        entity.setGenres(genreHelper.resolveGenres(series.getGenres()));
        SeriesEntity saved = seriesRepository.save(entity);
        return seriesMapper.toModel(saved);
    }

    @Override
    public Optional<Series> findByTitle(String title) {
        return seriesRepository.findByTitle(title)
                .map(seriesMapper::toModel);
    }

    @Override
    public boolean existsById(Long id) {
        return seriesRepository.existsById(id);
    }
}
