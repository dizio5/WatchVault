package com.dizio1.watchvault.review.application.usecase;

import com.dizio1.watchvault.review.application.ports.in.WriteReviewUseCase;
import com.dizio1.watchvault.review.application.ports.out.ReviewRepositoryPort;
import com.dizio1.watchvault.review.domain.Review;

import java.time.LocalDate;

public class WriteReviewUseCaseImpl implements WriteReviewUseCase {

    private final ReviewRepositoryPort reviewRepository;

    public WriteReviewUseCaseImpl(ReviewRepositoryPort reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review review(Review review) {
        review.setReviewedAt(LocalDate.now());
        return reviewRepository.save(review);
    }
}
