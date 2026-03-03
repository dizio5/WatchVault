package com.dizio1.watchvault.review.application.ports.out;

import com.dizio1.watchvault.common.infrastructure.in.web.page.PageResult;
import com.dizio1.watchvault.common.infrastructure.in.web.page.PaginationRequest;
import com.dizio1.watchvault.review.domain.Review;

public interface ReviewRepositoryPort {

    Review registerReview(Review review);

    PageResult<Review> getAllReviews(PaginationRequest request);
}
