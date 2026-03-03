package com.dizio1.watchvault.review.infrastructure.out.persistence;

import com.dizio1.watchvault.common.infrastructure.in.web.page.PageMapper;
import com.dizio1.watchvault.common.infrastructure.in.web.page.PageResult;
import com.dizio1.watchvault.common.infrastructure.in.web.page.PaginationRequest;
import com.dizio1.watchvault.review.application.ports.out.ReviewRepositoryPort;
import com.dizio1.watchvault.review.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaReviewRepositoryAdapter implements ReviewRepositoryPort {

    private final JpaReviewRepository jpaRepository;
    private final JpaReviewMapper reviewMapper;
    private final PageMapper pageMapper;

    public JpaReviewRepositoryAdapter(JpaReviewRepository jpaRepositor,
                                      JpaReviewMapper reviewMapper,
                                      PageMapper pageMapper) {
        this.jpaRepository = jpaRepositor;
        this.reviewMapper = reviewMapper;
        this.pageMapper = pageMapper;
    }

    @Override
    public Review registerReview(Review review) {
        ReviewEntity entity = reviewMapper.toEntity(review);
        ReviewEntity saved = jpaRepository.save(entity);
        return reviewMapper.toModel(saved);
    }

    @Override
    public PageResult<Review> getAllReviews(PaginationRequest request) {
        Pageable pageable = pageMapper.toPageable(request);
        Page<ReviewEntity> page = jpaRepository.findAll(pageable);

        List<Review> content = page.getContent()
                .stream()
                .map(reviewMapper::toModel)
                .toList();

        return new PageResult<>(
                content,
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getSize());
    }
}
