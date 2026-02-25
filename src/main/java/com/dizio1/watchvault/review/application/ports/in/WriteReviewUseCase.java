package com.dizio1.watchvault.review.application.ports.in;

import com.dizio1.watchvault.review.domain.Review;

public interface WriteReviewUseCase {

    Review createReview(Review review);
}
