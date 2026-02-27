package com.dizio1.watchvault.review.infrastructure.out.persistence;

import com.dizio1.watchvault.review.application.ports.out.ReviewRepositoryPort;
import com.dizio1.watchvault.review.domain.Review;
import org.springframework.stereotype.Component;

@Component
public class JpaReviewRepositoryAdapter implements ReviewRepositoryPort {

    private final JpaReviewRepository jpaRepository;
    private final JpaReviewMapper jpaReviewMapper;

    public JpaReviewRepositoryAdapter(JpaReviewRepository jpaRepositor, JpaReviewMapper jpaReviewMapper) {
        this.jpaRepository = jpaRepositor;
        this.jpaReviewMapper = jpaReviewMapper;
    }

    @Override
    public Review registerReview(Review review) {
        ReviewEntity entity = jpaReviewMapper.toEntity(review);
        ReviewEntity saved = jpaRepository.save(entity);
        return jpaReviewMapper.toModel(saved);
    }
}
