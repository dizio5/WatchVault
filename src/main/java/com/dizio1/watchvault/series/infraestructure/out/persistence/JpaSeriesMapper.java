package com.dizio1.watchvault.series.infraestructure.out.persistence;

import com.dizio1.watchvault.series.domain.model.Series;
import org.springframework.stereotype.Component;

@Component
public class JpaSeriesMapper {

    public SeriesEntity toEntity(Series series) {
        SeriesEntity entity = new SeriesEntity();
        entity.setTitle(series.getTitle());
        entity.setId(series.getId());
        entity.setAdult(series.isAdult());
        entity.setDescription(series.getOverview());
        entity.setSeasons(series.getSeasons());
        entity.setCreatedBy(series.getCreatedBy());
        entity.setGenres(series.getGenres());
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
        series.setSeasons(entity.getSeasons());
        series.setCreatedBy(entity.getCreatedBy());
        series.setGenres(entity.getGenres());
        series.setFirstAirDate(entity.getFirstAirDate());
        series.setLastAirDate(entity.getLastAirDate());
        series.setStatus(entity.getStatus());
        series.setAdult(entity.isAdult());
        series.setOverview(entity.getDescription());
        return series;
    }
}
