package com.dizio1.watchvault.review.infrastructure.in.web;

import com.dizio1.watchvault.common.infrastructure.in.web.page.PageMapper;
import com.dizio1.watchvault.common.infrastructure.in.web.page.PageResult;
import com.dizio1.watchvault.review.application.ports.in.CreateReviewUseCase;
import com.dizio1.watchvault.review.application.ports.in.GetReviewsUseCase;
import com.dizio1.watchvault.review.domain.Review;
import com.dizio1.watchvault.review.infrastructure.in.web.dto.CreateReviewRequest;
import com.dizio1.watchvault.review.infrastructure.in.web.dto.RestReviewMapper;
import com.dizio1.watchvault.review.infrastructure.in.web.dto.ReviewResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final CreateReviewUseCase createReviewUseCase;
    private final GetReviewsUseCase getReviewsUseCase;
    private final RestReviewMapper reviewMapper;
    private final PageMapper pageMapper;

    public ReviewController(CreateReviewUseCase createReviewUseCase,
                            GetReviewsUseCase getReviewsUseCase,
                            PageMapper pageMapper,
                            RestReviewMapper reviewMapper) {
        this.createReviewUseCase = createReviewUseCase;
        this.getReviewsUseCase = getReviewsUseCase;
        this.reviewMapper = reviewMapper;
        this.pageMapper = pageMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse reviewSeries(@RequestBody @Valid CreateReviewRequest request) {
        Review review = createReviewUseCase.createReview(reviewMapper.toModel(request));
        return reviewMapper.toResponse(review);
    }

    @GetMapping
    public Page<ReviewResponse> getAllReviews(@PageableDefault Pageable pageable) {
        PageResult<Review> results = getReviewsUseCase.getReviews(pageMapper.toModel(pageable));
        List<ReviewResponse> content = results.content()
                .stream()
                .map(reviewMapper::toResponse)
                .toList();
        return new PageImpl<>(content, pageable, results.totalElements());
    }

}
