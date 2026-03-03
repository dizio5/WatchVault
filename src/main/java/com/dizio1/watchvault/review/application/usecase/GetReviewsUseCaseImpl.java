package com.dizio1.watchvault.review.application.usecase;

import com.dizio1.watchvault.common.infrastructure.in.web.page.PageQuery;
import com.dizio1.watchvault.common.infrastructure.in.web.page.PageResult;
import com.dizio1.watchvault.review.application.ports.in.GetReviewsUseCase;
import com.dizio1.watchvault.review.application.ports.out.ReviewRepositoryPort;
import com.dizio1.watchvault.review.domain.Review;

public class GetReviewsUseCaseImpl implements GetReviewsUseCase {

    private final ReviewRepositoryPort reviewRepository;

    public GetReviewsUseCaseImpl(ReviewRepositoryPort reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public PageResult<Review> getReviews(PageQuery request) {
        return reviewRepository.getAllReviews(request);
    }
}
