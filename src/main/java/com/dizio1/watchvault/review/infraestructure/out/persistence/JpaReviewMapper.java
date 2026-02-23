package com.dizio1.watchvault.review.infraestructure.out.persistence;

import com.dizio1.watchvault.review.domain.Review;
import org.springframework.stereotype.Component;

@Component
public class JpaReviewMapper {

    public ReviewEntity fromModelToEntity(Review review) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setTitle(review.getTitle());
        reviewEntity.setReviewedAt(review.getReviewedAt());
        reviewEntity.setId(review.getId());
        reviewEntity.setStars(review.getStars());
        reviewEntity.setDescription(reviewEntity.getDescription());
        return reviewEntity;
    }

    public Review fromEntitytoModel(ReviewEntity entity) {
        Review review = new Review();
        review.setId(entity.getId());
        review.setDescription(entity.getDescription());
        review.setTitle(entity.getTitle());
        review.setStars(entity.getStars());
        review.setReviewedAt(entity.getReviewedAt());
        return review;
    }
}
