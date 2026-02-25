package com.dizio1.watchvault.review.infraestructure.in.web;

import com.dizio1.watchvault.review.application.ports.in.WriteReviewUseCase;
import com.dizio1.watchvault.review.domain.Review;
import com.dizio1.watchvault.review.infraestructure.in.web.dto.CreateReviewRequest;
import com.dizio1.watchvault.review.infraestructure.in.web.dto.RestReviewMapper;
import com.dizio1.watchvault.review.infraestructure.in.web.dto.ReviewResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final WriteReviewUseCase writeReviewUseCase;
    private final RestReviewMapper reviewMapper;

    public ReviewController(WriteReviewUseCase writeReviewUseCase, RestReviewMapper reviewMapper) {
        this.writeReviewUseCase = writeReviewUseCase;
        this.reviewMapper = reviewMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse review(@RequestBody @Valid CreateReviewRequest request) {
        Review review = writeReviewUseCase.createReview(reviewMapper.toModel(request));

        return reviewMapper.toResponse(review);
    }
}
