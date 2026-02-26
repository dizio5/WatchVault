package com.dizio1.watchvault.series.infraestructure.out.tmdb;

import com.dizio1.watchvault.series.application.ports.out.SeriesCatalogPort;
import com.dizio1.watchvault.series.domain.exception.SeriesNotFoundException;
import com.dizio1.watchvault.series.domain.model.Series;
import com.dizio1.watchvault.series.infraestructure.in.web.dto.RestSeriesMapper;
import com.dizio1.watchvault.series.infraestructure.out.tmdb.dto.SearchSeriesIdResponse;
import com.dizio1.watchvault.series.infraestructure.out.tmdb.dto.TmdbSeriesSearchResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class TmdbSeriesCatalogAdapter implements SeriesCatalogPort {

    private final RestClient tmdb;
    private final RestSeriesMapper seriesMapper;

    public TmdbSeriesCatalogAdapter(RestClient tmdb, RestSeriesMapper seriesMapper) {
        this.tmdb = tmdb;
        this.seriesMapper = seriesMapper;
    }

    private Long searchSeriesId(String query) {
        SearchSeriesIdResponse result = tmdb.get()
                .uri(uriBuilder -> uriBuilder.path("/search/tv")
                        .queryParam("query", query)
                        .queryParam("include_adult", true)
                        .build())
                .retrieve()
                .body(SearchSeriesIdResponse.class);

        return Optional.ofNullable(result)
                .map(SearchSeriesIdResponse::results)
                .orElse(List.of())
                .stream()
                .map(SearchSeriesIdResponse.SeriesId::id)
                .findFirst()
                .orElseThrow(() -> new SeriesNotFoundException(query));
    }

    @Override
    public Series searchByTitle(String title) {
        Long id = searchSeriesId(title);
        TmdbSeriesSearchResponse response = tmdb.get()
                .uri("/tv/{id}", id)
                .retrieve()
                .body(TmdbSeriesSearchResponse.class);

        return seriesMapper.toModel(Objects.requireNonNull(response));
    }
}
