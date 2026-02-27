package com.dizio1.watchvault.review.application.ports.in;

import com.dizio1.watchvault.review.domain.Review;

public interface CreateReviewUseCase {

    Review createReview(Review review);
}
