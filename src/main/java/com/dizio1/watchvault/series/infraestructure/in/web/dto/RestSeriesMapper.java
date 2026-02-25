package com.dizio1.watchvault.series.infraestructure.in.web.dto;

import com.dizio1.watchvault.movie.infraestructure.in.web.dto.mapper.RestGenreMapper;
import com.dizio1.watchvault.series.domain.model.Series;
import com.dizio1.watchvault.series.infraestructure.out.tmdb.dto.TmdbSeriesSearchResponse;
import org.springframework.stereotype.Component;

@Component
public class RestSeriesMapper {

    private final RestGenreMapper genreMapper;

    public RestSeriesMapper(RestGenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }

    public Series toModel(TmdbSeriesSearchResponse response) {
        Series series = new Series();
        series.setTitle(response.name());
        series.setId(response.id());
        series.setAdult(response.adult());
        series.setDescription(response.overview());
        series.setCreatedBy(response.createdBy().getFirst().name());
        series.setGenres(response.genres());
        series.setSeasons(response.numberOfSeasons());
        series.setEpisodes(response.numberOfEpisodes());
        series.setStatus(response.status());
        series.setFirstAirDate(response.firstAirDate());
        series.setLastAirDate(response.lastAirDate());
        return series;
    }

    public SeriesResponse toResponse(Series series) {
        return new SeriesResponse(series.getTitle(),
                series.getDescription(),
                series.getCreatedBy(),
                series.getEpisodes(),
                series.getSeasons(),
                series.getFirstAirDate(),
                series.getLastAirDate(),
                series.getStatus(),
                series.isAdult(),
                series.getGenres()
                        .stream()
                        .map(genreMapper::toResponse)
                        .toList());
    }
}
