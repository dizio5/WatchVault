package com.dizio1.watchvault.review.infraestructure.in.web.dto;

import com.dizio1.watchvault.review.domain.Review;
import com.dizio1.watchvault.review.domain.ShowType;
import org.springframework.stereotype.Component;

@Component
public class RestReviewMapper {

    public Review toModel(CreateReviewRequest request) {
        Review review = new Review();
        review.setDescription(request.description());
        review.setStars(request.stars());
        review.setShowType(ShowType.from(request.showType()));
        review.setTitle(request.title());
        return review;
    }

    public ReviewResponse toResponse(Review review) {
        return new ReviewResponse(review.getShowType(),
                review.getTitle(),
                review.getDescription(),
                review.getStars(),
                review.getReviewedAt());
    }
}