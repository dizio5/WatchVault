package com.dizio1.watchvault.series.infrastructure.in.web.dto;

import com.dizio1.watchvault.genre.infrastructure.in.web.dto.RestGenreMapper;
import com.dizio1.watchvault.series.domain.model.Series;
import com.dizio1.watchvault.series.infrastructure.out.tmdb.dto.TmdbSeriesSearchResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        series.setOverview(response.overview());
        String creator = Optional.ofNullable(response.createdBy())
                .stream()
                .flatMap(List::stream)
                .map(TmdbSeriesSearchResponse.TmdbCreatorDto::name)
                .findFirst()
                .orElse(null);
        series.setCreatedBy(creator);
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
                series.getOverview(),
                series.getCreatedBy(),
                series.getEpisodes(),
                series.getSeasons(),
                series.getFirstAirDate(),
                series.getLastAirDate(),
                series.getStatus(),
                series.getGenres()
                        .stream()
                        .map(genreMapper::toResponse)
                        .toList());
    }
}
