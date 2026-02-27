package com.dizio1.watchvault.series.infrastructure.config;

import com.dizio1.watchvault.series.application.ports.in.SearchSeriesUseCase;
import com.dizio1.watchvault.series.application.ports.out.SeriesCatalogPort;
import com.dizio1.watchvault.series.application.usecase.SearchSeriesUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeriesApplicationConfig {

    @Bean
    SearchSeriesUseCase searchSeriesUseCase(SeriesCatalogPort seriesCatalogPort) {
        return new SearchSeriesUseCaseImpl(seriesCatalogPort);
    }
}
