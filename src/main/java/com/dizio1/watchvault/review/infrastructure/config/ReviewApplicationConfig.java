package com.dizio1.watchvault.review.infrastructure.config;

import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.application.ports.out.MovieRepositoryPort;
import com.dizio1.watchvault.review.application.ports.in.CreateReviewUseCase;
import com.dizio1.watchvault.review.application.ports.out.ReviewRepositoryPort;
import com.dizio1.watchvault.review.application.usecase.CreateReviewUseCaseImpl;
import com.dizio1.watchvault.series.application.ports.out.SeriesCatalogPort;
import com.dizio1.watchvault.series.application.ports.out.SeriesRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewApplicationConfig {

    @Bean
    CreateReviewUseCase writeReviewUseCase(ReviewRepositoryPort reviewRepositoryPort,
                                           MovieRepositoryPort movieRepositoryPort,
                                           SeriesRepositoryPort seriesRepositoryPort,
                                           MovieCatalogPort movieCatalogPort,
                                           SeriesCatalogPort seriesCatalogPort) {
        return new CreateReviewUseCaseImpl(reviewRepositoryPort,
                seriesRepositoryPort,
                movieRepositoryPort,
                movieCatalogPort,
                seriesCatalogPort);
    }
}
