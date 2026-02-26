package com.dizio1.watchvault.review.infrastructure.config;

import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.application.ports.out.MovieRepositoryPort;
import com.dizio1.watchvault.review.application.ports.in.WriteReviewUseCase;
import com.dizio1.watchvault.review.application.ports.out.ReviewRepositoryPort;
import com.dizio1.watchvault.review.application.usecase.WriteReviewUseCaseImpl;
import com.dizio1.watchvault.series.application.ports.out.SeriesCatalogPort;
import com.dizio1.watchvault.series.application.ports.out.SeriesRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewApplicationConfig {

    @Bean
    WriteReviewUseCase writeReviewUseCase(ReviewRepositoryPort reviewRepositoryPort,
                                          MovieRepositoryPort movieRepositoryPort,
                                          SeriesRepositoryPort seriesRepositoryPort,
                                          MovieCatalogPort movieCatalogPort,
                                          SeriesCatalogPort seriesCatalogPort) {
        return new WriteReviewUseCaseImpl(reviewRepositoryPort,
                seriesRepositoryPort,
                movieRepositoryPort,
                movieCatalogPort,
                seriesCatalogPort);
    }
}
