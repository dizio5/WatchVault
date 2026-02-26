package com.dizio1.watchvault.review.application.usecase;

import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.application.ports.out.MovieRepositoryPort;
import com.dizio1.watchvault.movie.domain.model.Movie;
import com.dizio1.watchvault.review.application.ports.in.WriteReviewUseCase;
import com.dizio1.watchvault.review.application.ports.out.ReviewRepositoryPort;
import com.dizio1.watchvault.review.domain.Review;
import com.dizio1.watchvault.review.domain.ShowType;
import com.dizio1.watchvault.series.application.ports.out.SeriesCatalogPort;
import com.dizio1.watchvault.series.application.ports.out.SeriesRepositoryPort;
import com.dizio1.watchvault.series.domain.model.Series;

import java.time.LocalDate;

public class WriteReviewUseCaseImpl implements WriteReviewUseCase {

    private final ReviewRepositoryPort reviewRepository;
    private final SeriesRepositoryPort seriesRepository;
    private final MovieRepositoryPort movieRepository;
    private final MovieCatalogPort movieCatalog;
    private final SeriesCatalogPort seriesCatalog;

    public WriteReviewUseCaseImpl(ReviewRepositoryPort reviewRepository,
                                  SeriesRepositoryPort seriesRepository,
                                  MovieRepositoryPort movieRepository,
                                  MovieCatalogPort movieCatalog,
                                  SeriesCatalogPort seriesCatalog) {
        this.reviewRepository = reviewRepository;
        this.seriesRepository = seriesRepository;
        this.movieRepository = movieRepository;
        this.movieCatalog = movieCatalog;
        this.seriesCatalog = seriesCatalog;
    }

    @Override
    public Review createReview(Review review) {
        Long showId = review.getShowType().equals(ShowType.SERIES)
                ? createOrFindSeries(review.getTitle())
                : createOrFindMovie(review.getTitle());

        review.setReviewedAt(LocalDate.now());
        review.setShowId(showId);
        return reviewRepository.save(review);
    }

    private Long createOrFindSeries(String title) {
        Series series = seriesRepository.findByTitle(title)
                .orElseGet(() -> {
                    Series newSeries = seriesCatalog.searchByTitle(title);
                    return seriesRepository.save(newSeries);
                });
        return series.getId();
    }

    private Long createOrFindMovie(String title) {
        Movie movie = movieRepository.findByTitle(title)
                .orElseGet(() -> {
                    Movie newMovie = movieCatalog.searchByTitle(title);
                    return movieRepository.save(newMovie);
                });
        return movie.getId();
    }
}
