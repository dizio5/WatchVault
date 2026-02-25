package com.dizio1.watchvault.review.infraestructure.in.web;

import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.domain.model.Movie;
import com.dizio1.watchvault.review.application.ports.in.WriteReviewUseCase;
import com.dizio1.watchvault.review.domain.Review;
import com.dizio1.watchvault.review.infraestructure.in.web.dto.CreateReviewRequest;
import com.dizio1.watchvault.review.infraestructure.in.web.dto.RestReviewMapper;
import com.dizio1.watchvault.review.infraestructure.in.web.dto.ReviewResponse;
import com.dizio1.watchvault.series.application.ports.in.SearchSeriesUseCase;
import com.dizio1.watchvault.series.domain.model.Series;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final WriteReviewUseCase writeReviewUseCase;
    private final SearchSeriesUseCase searchSeriesUseCase;
    private final SearchMovieUseCase searchMovieUseCase;
    private final RestReviewMapper reviewMapper;

    public ReviewController(WriteReviewUseCase writeReviewUseCase,
                            SearchSeriesUseCase searchSeriesUseCase,
                            SearchMovieUseCase searchMovieUseCase,
                            RestReviewMapper reviewMapper) {
        this.writeReviewUseCase = writeReviewUseCase;
        this.searchSeriesUseCase = searchSeriesUseCase;
        this.searchMovieUseCase = searchMovieUseCase;
        this.reviewMapper = reviewMapper;
    }

    @PostMapping("/series")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse reviewSeries(@RequestBody @Valid CreateReviewRequest request) {
        Series series = searchSeriesUseCase.searchByTitle(request.title());
        Review review = writeReviewUseCase.createReview(reviewMapper.toModel(request));
        return reviewMapper.toResponse(review);
    }

    @PostMapping("/movie")
    public ReviewResponse reviewMovie(@RequestBody @Valid CreateReviewRequest request) {
        Movie movie = searchMovieUseCase.getMovieDetails(request.title());
        Review review = writeReviewUseCase.createReview(reviewMapper.toModel(request));
        return reviewMapper.toResponse(review);
    }
}
