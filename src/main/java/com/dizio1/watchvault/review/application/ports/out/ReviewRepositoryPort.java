package com.dizio1.watchvault.review.application.ports.out;

import com.dizio1.watchvault.review.domain.Review;

public interface ReviewRepositoryPort {

    Review registerReview(Review review);
}
