package com.dizio1.watchvault.review.application.ports.in;

import com.dizio1.watchvault.common.infrastructure.in.web.page.PageQuery;
import com.dizio1.watchvault.common.infrastructure.in.web.page.PageResult;
import com.dizio1.watchvault.review.domain.Review;

public interface GetReviewsUseCase {

    PageResult<Review> getReviews(PageQuery request);
}
