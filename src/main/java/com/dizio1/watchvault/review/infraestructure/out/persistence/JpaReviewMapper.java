package com.dizio1.watchvault.review.infraestructure.out.persistence;

import com.dizio1.watchvault.review.domain.Review;
import org.springframework.stereotype.Component;

@Component
public class JpaReviewMapper {

    public ReviewEntity fromModelToEntity(Review review) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setTitle(review.getTitle());
        reviewEntity.setReviewedAt(review.getReviewedAt());
        reviewEntity.setShowType(review.getShowType());
        reviewEntity.setId(review.getId());
        reviewEntity.setRating(review.getRating());
        reviewEntity.setDescription(review.getDescription());
        return reviewEntity;
    }

    public Review fromEntitytoModel(ReviewEntity entity) {
        Review review = new Review();
        review.setId(entity.getId());
        review.setDescription(entity.getDescription());
        review.setShowType(entity.getShowType());
        review.setTitle(entity.getTitle());
        review.setRating(entity.getRating());
        review.setReviewedAt(entity.getReviewedAt());
        return review;
    }
}
