package com.dizio1.watchvault.review.infrastructure.in.web;

import com.dizio1.watchvault.review.application.ports.in.CreateReviewUseCase;
import com.dizio1.watchvault.review.domain.Review;
import com.dizio1.watchvault.review.infrastructure.in.web.dto.CreateReviewRequest;
import com.dizio1.watchvault.review.infrastructure.in.web.dto.RestReviewMapper;
import com.dizio1.watchvault.review.infrastructure.in.web.dto.ReviewResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final CreateReviewUseCase createReviewUseCase;

    private final RestReviewMapper reviewMapper;

    public ReviewController(CreateReviewUseCase createReviewUseCase,
                            RestReviewMapper reviewMapper) {
        this.createReviewUseCase = createReviewUseCase;
        this.reviewMapper = reviewMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse reviewSeries(@RequestBody @Valid CreateReviewRequest request) {
        Review review = createReviewUseCase.createReview(reviewMapper.toModel(request));
        return reviewMapper.toResponse(review);
    }
}
