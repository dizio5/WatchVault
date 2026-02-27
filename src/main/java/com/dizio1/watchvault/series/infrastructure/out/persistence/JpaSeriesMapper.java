package com.dizio1.watchvault.series.infrastructure.out.persistence;

import com.dizio1.watchvault.genre.infrastructure.out.persistence.JpaGenreMapper;
import com.dizio1.watchvault.series.domain.model.Series;
import org.springframework.stereotype.Component;

@Component
public class JpaSeriesMapper {

    private final JpaGenreMapper genreMapper;

    public JpaSeriesMapper(JpaGenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }

    public SeriesEntity toEntity(Series series) {
        SeriesEntity entity = new SeriesEntity();
        entity.setTitle(series.getTitle());
        entity.setId(series.getId());
        entity.setDescription(series.getOverview());
        entity.setSeasons(series.getSeasons());
        entity.setCreatedBy(series.getCreatedBy());
        entity.setFirstAirDate(series.getFirstAirDate());
        entity.setLastAirDate(series.getLastAirDate());
        entity.setStatus(series.getStatus());
        entity.setEpisodes(series.getEpisodes());
        return entity;
    }

    public Series toModel(SeriesEntity entity) {
        Series series = new Series();
        series.setId(entity.getId());
        series.setTitle(entity.getTitle());
        series.setEpisodes(entity.getEpisodes());
        series.setCreatedBy(entity.getCreatedBy());
        series.setGenres(entity.getGenres()
                .stream()
                .map(genreMapper::toModel)
                .toList());
        series.setFirstAirDate(entity.getFirstAirDate());
        series.setLastAirDate(entity.getLastAirDate());
        series.setStatus(entity.getStatus());
        series.setOverview(entity.getDescription());
        series.setSeasons(entity.getSeasons());
        return series;
    }
}
