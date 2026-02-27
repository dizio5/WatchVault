package com.dizio1.watchvault.series.infrastructure.in.web;

import com.dizio1.watchvault.series.application.ports.in.SearchSeriesUseCase;
import com.dizio1.watchvault.series.domain.model.Series;
import com.dizio1.watchvault.series.infrastructure.in.web.dto.RestSeriesMapper;
import com.dizio1.watchvault.series.infrastructure.in.web.dto.SeriesResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/series")
public class SeriesController {

    private final SearchSeriesUseCase searchSeriesUseCase;
    private final RestSeriesMapper seriesMapper;

    public SeriesController(SearchSeriesUseCase searchSeriesUseCase, RestSeriesMapper seriesMapper) {
        this.searchSeriesUseCase = searchSeriesUseCase;
        this.seriesMapper = seriesMapper;
    }

    @GetMapping("/search")
    public SeriesResponse searchSeries(@RequestParam String name) {
        Series series = searchSeriesUseCase.searchByTitle(name);
        return seriesMapper.toResponse(series);
    }
}
