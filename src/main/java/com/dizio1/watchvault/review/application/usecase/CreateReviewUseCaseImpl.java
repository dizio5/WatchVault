package com.dizio1.watchvault.review.application.usecase;

import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.application.ports.out.MovieRepositoryPort;
import com.dizio1.watchvault.movie.domain.model.Movie;
import com.dizio1.watchvault.review.application.ports.in.CreateReviewUseCase;
import com.dizio1.watchvault.review.application.ports.out.ReviewRepositoryPort;
import com.dizio1.watchvault.review.domain.Review;
import com.dizio1.watchvault.review.domain.ShowType;
import com.dizio1.watchvault.series.application.ports.out.SeriesCatalogPort;
import com.dizio1.watchvault.series.application.ports.out.SeriesRepositoryPort;
import com.dizio1.watchvault.series.domain.model.Series;

import java.time.LocalDate;

public class CreateReviewUseCaseImpl implements CreateReviewUseCase {

    private final ReviewRepositoryPort reviewRepository;
    private final SeriesRepositoryPort seriesRepository;
    private final MovieRepositoryPort movieRepository;
    private final MovieCatalogPort movieCatalog;
    private final SeriesCatalogPort seriesCatalog;

    public CreateReviewUseCaseImpl(ReviewRepositoryPort reviewRepository,
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
        Long showId = review.getShowType() == (ShowType.SERIES)
                ? registerOrFindSeries(review.getTitle())
                : registerOrFindMovies(review.getTitle());

        review.setReviewedAt(LocalDate.now());
        review.setShowId(showId);
        return reviewRepository.registerReview(review);
    }

    private Long registerOrFindSeries(String title) {
        Series series = seriesCatalog.searchByTitle(title);

        if (seriesRepository.existsById(series.getId())) {
            return series.getId();
        }
        Series saved = seriesRepository.registerSeries(series);
        return saved.getId();
    }

    private Long registerOrFindMovies(String title) {
        Movie movie = movieCatalog.searchByTitle(title);

        if (movieRepository.existsById(movie.getId())) {
            return movie.getId();
        }
        Movie saved = movieRepository.registerMovie(movie);
        return saved.getId();
    }
}
