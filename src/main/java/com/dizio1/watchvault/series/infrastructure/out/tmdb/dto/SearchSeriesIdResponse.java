package com.dizio1.watchvault.series.infrastructure.out.tmdb.dto;

import java.util.List;

public record SearchSeriesIdResponse(
        List<SeriesId> results
) {
    public record SeriesId(Long id) {

    }
}
