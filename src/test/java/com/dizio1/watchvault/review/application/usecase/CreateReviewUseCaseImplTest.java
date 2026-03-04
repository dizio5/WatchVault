package com.dizio1.watchvault.review.application.usecase;

import com.dizio1.watchvault.genre.domain.model.Genre;
import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.application.ports.out.MovieRepositoryPort;
import com.dizio1.watchvault.movie.domain.model.Movie;
import com.dizio1.watchvault.review.application.ports.out.ReviewRepositoryPort;
import com.dizio1.watchvault.review.domain.model.Review;
import com.dizio1.watchvault.review.domain.model.ShowType;
import com.dizio1.watchvault.series.application.ports.out.SeriesCatalogPort;
import com.dizio1.watchvault.series.application.ports.out.SeriesRepositoryPort;
import com.dizio1.watchvault.series.domain.model.Series;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateReviewUseCaseImplTest {

    @Mock
    private ReviewRepositoryPort reviewRepository;
    @Mock
    private SeriesRepositoryPort seriesRepository;
    @Mock
    private MovieRepositoryPort movieRepository;
    @Mock
    private MovieCatalogPort movieCatalog;
    @Mock
    private SeriesCatalogPort seriesCatalog;

    @InjectMocks
    private CreateReviewUseCaseImpl createReviewUseCase;

    @Test
    public void createReview_givenExistingSeries_returnsReview() {
        Review review = new Review();
        review.setShowType(ShowType.SERIES);
        review.setTitle("Breaking Bad");
        review.setId(null);
        review.setShowId(1L);
        review.setDescription("The one who knocks");
        review.setRating(10);
        review.setReviewedAt(LocalDate.now());

        Review registered = new Review();
        registered.setShowType(ShowType.SERIES);
        registered.setTitle("Breaking Bad");
        registered.setId(1L);
        registered.setShowId(1L);
        registered.setDescription("The one who knocks");
        registered.setRating(10);
        registered.setReviewedAt(LocalDate.now());

        Series series = new Series();
        series.setId(1L);
        series.setTitle("Breaking Bad");
        series.setGenres(List.of(new Genre(1L, "Drama"), new Genre(2L, "Crimen")));
        series.setEpisodes(62);
        series.setSeasons(5);
        series.setFirstAirDate(LocalDate.of(2008, 1, 20));
        series.setLastAirDate(LocalDate.of(2013, 9, 29));
        series.setCreatedBy("Vince Gilligan");
        series.setOverview("Private Domicile Bitch");
        series.setStatus("Ended");

        when(seriesCatalog.searchByTitle(series.getTitle())).thenReturn(series);
        when(seriesRepository.existsById(series.getId())).thenReturn(true);
        when(reviewRepository.registerReview(review)).thenReturn(registered);

        Review result = createReviewUseCase.createReview(review);

        assertEquals(registered.getId(), result.getId());
        assertEquals(registered.getTitle(), result.getTitle());
        assertEquals(registered.getReviewedAt(), result.getReviewedAt());
        assertEquals(registered.getRating(), result.getRating());
        assertEquals(registered.getShowType(), result.getShowType());
        assertEquals(registered.getDescription(), result.getDescription());
        assertEquals(registered.getShowId(), result.getShowId());

        verify(seriesCatalog).searchByTitle(series.getTitle());
        verify(seriesRepository).existsById(1L);
        verify(seriesRepository, never()).registerSeries(series);
        verify(reviewRepository).registerReview(review);
        verify(movieCatalog, never()).searchByTitle(any());
    }

    @Test
    public void createReview_givenNonExistingSeries_returnsReview() {
        Review review = new Review();
        review.setShowType(ShowType.SERIES);
        review.setTitle("Breaking Bad");
        review.setId(null);
        review.setShowId(1L);
        review.setDescription("The one who knocks");
        review.setRating(10);
        review.setReviewedAt(LocalDate.now());

        Review registered = new Review();
        registered.setShowType(ShowType.SERIES);
        registered.setTitle("Breaking Bad");
        registered.setId(1L);
        registered.setShowId(1L);
        registered.setDescription("The one who knocks");
        registered.setRating(10);
        registered.setReviewedAt(LocalDate.now());

        Series series = new Series();
        series.setId(1L);
        series.setTitle("Breaking Bad");
        series.setGenres(List.of(new Genre(1L, "Drama"), new Genre(2L, "Crimen")));
        series.setEpisodes(62);
        series.setSeasons(5);
        series.setFirstAirDate(LocalDate.of(2008, 1, 20));
        series.setLastAirDate(LocalDate.of(2013, 9, 29));
        series.setCreatedBy("Vince Gilligan");
        series.setOverview("Private Domicile Bitch");
        series.setStatus("Ended");

        when(seriesCatalog.searchByTitle(series.getTitle())).thenReturn(series);
        when(seriesRepository.existsById(series.getId())).thenReturn(false);
        when(seriesRepository.registerSeries(series)).thenReturn(series);
        when(reviewRepository.registerReview(review)).thenReturn(registered);

        Review result = createReviewUseCase.createReview(review);

        assertEquals(registered.getId(), result.getId());
        assertEquals(registered.getTitle(), result.getTitle());
        assertEquals(registered.getReviewedAt(), result.getReviewedAt());
        assertEquals(registered.getRating(), result.getRating());
        assertEquals(registered.getShowType(), result.getShowType());
        assertEquals(registered.getDescription(), result.getDescription());
        assertEquals(registered.getShowId(), result.getShowId());

        verify(seriesCatalog).searchByTitle(series.getTitle());
        verify(seriesRepository).existsById(series.getId());
        verify(reviewRepository).registerReview(review);
        verify(seriesRepository).registerSeries(series);
        verify(movieCatalog, never()).searchByTitle(any());
    }

    @Test
    public void createReview_givenExistingMovie_returnsReview() {
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("The Godfather");
        movie.setRuntime(175);
        movie.setGenres(List.of(new Genre(1L, "Crime"), new Genre(2L, "Drama")));
        movie.setOverview("Vito Corleone");
        movie.setReleaseDate(LocalDate.of(1972, 3, 15));
        movie.setDirectedBy("Francis Ford Coppola");

        Review review = new Review();
        review.setShowType(ShowType.MOVIE);
        review.setTitle("The Godfather");
        review.setId(null);
        review.setShowId(1L);
        review.setDescription("MASTERPIECE");
        review.setRating(10);
        review.setReviewedAt(LocalDate.now());

        Review registered = new Review();
        registered.setShowType(ShowType.MOVIE);
        registered.setTitle("The Godfather");
        registered.setId(1L);
        registered.setShowId(1L);
        registered.setDescription("MASTERPIECE");
        registered.setRating(10);
        registered.setReviewedAt(LocalDate.now());

        when(movieCatalog.searchByTitle(movie.getTitle())).thenReturn(movie);
        when(movieRepository.existsById(movie.getId())).thenReturn(true);
        when(reviewRepository.registerReview(review)).thenReturn(registered);

        Review result = createReviewUseCase.createReview(review);

        assertEquals(registered.getShowId(), result.getShowId());
        assertEquals(registered.getId(), result.getId());
        assertEquals(registered.getRating(), result.getRating());
        assertEquals(registered.getReviewedAt(), result.getReviewedAt());
        assertEquals(registered.getDescription(), result.getDescription());
        assertEquals(registered.getTitle(), result.getTitle());
        assertEquals(registered.getShowType(), result.getShowType());

        verify(movieCatalog).searchByTitle(movie.getTitle());
        verify(movieRepository).existsById(movie.getId());
        verify(movieRepository, never()).registerMovie(any(Movie.class));
        verify(reviewRepository).registerReview(review);
    }

    @Test
    public void createReview_givenNonExistingMovie_returnsReview() {
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("The Godfather");
        movie.setRuntime(175);
        movie.setGenres(List.of(new Genre(1L, "Crime"), new Genre(2L, "Drama")));
        movie.setOverview("Vito Corleone");
        movie.setReleaseDate(LocalDate.of(1972, 3, 15));
        movie.setDirectedBy("Francis Ford Coppola");

        Review review = new Review();
        review.setShowType(ShowType.MOVIE);
        review.setTitle("The Godfather");
        review.setId(null);
        review.setShowId(1L);
        review.setDescription("MASTERPIECE");
        review.setRating(10);
        review.setReviewedAt(LocalDate.now());

        Review registered = new Review();
        registered.setShowType(ShowType.MOVIE);
        registered.setTitle("The Godfather");
        registered.setId(1L);
        registered.setShowId(1L);
        registered.setDescription("MASTERPIECE");
        registered.setRating(10);
        registered.setReviewedAt(LocalDate.now());

        when(movieCatalog.searchByTitle(movie.getTitle())).thenReturn(movie);
        when(movieRepository.existsById(movie.getId())).thenReturn(false);
        when(movieRepository.registerMovie(movie)).thenReturn(movie);
        when(reviewRepository.registerReview(review)).thenReturn(registered);

        Review result = createReviewUseCase.createReview(review);

        assertEquals(registered.getShowId(), result.getShowId());
        assertEquals(registered.getId(), result.getId());
        assertEquals(registered.getRating(), result.getRating());
        assertEquals(registered.getReviewedAt(), result.getReviewedAt());
        assertEquals(registered.getDescription(), result.getDescription());
        assertEquals(registered.getTitle(), result.getTitle());
        assertEquals(registered.getShowType(), result.getShowType());

        verify(movieCatalog).searchByTitle(movie.getTitle());
        verify(movieRepository).existsById(movie.getId());
        verify(movieRepository).registerMovie(movie);
        verify(reviewRepository).registerReview(review);
    }
}
