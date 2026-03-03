package com.dizio1.watchvault.review.application.ports.in;

import com.dizio1.watchvault.common.infrastructure.in.web.page.PageResult;
import com.dizio1.watchvault.common.infrastructure.in.web.page.PaginationRequest;
import com.dizio1.watchvault.review.domain.model.Review;

public interface GetReviewsUseCase {

    PageResult<Review> getReviews(PaginationRequest request);
}
