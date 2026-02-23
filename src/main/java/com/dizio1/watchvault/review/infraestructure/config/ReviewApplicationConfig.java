package com.dizio1.watchvault.review.infraestructure.config;

import com.dizio1.watchvault.review.application.ports.in.WriteReviewUseCase;
import com.dizio1.watchvault.review.application.ports.out.ReviewRepositoryPort;
import com.dizio1.watchvault.review.application.usecase.WriteReviewUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewApplicationConfig {

    @Bean
    WriteReviewUseCase writeReviewUseCase(ReviewRepositoryPort reviewRepositoryPort) {
        return new WriteReviewUseCaseImpl(reviewRepositoryPort);
    }
}
