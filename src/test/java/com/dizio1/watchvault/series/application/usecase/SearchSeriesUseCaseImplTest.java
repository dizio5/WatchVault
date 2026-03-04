package com.dizio1.watchvault.series.application.usecase;

import com.dizio1.watchvault.genre.domain.model.Genre;
import com.dizio1.watchvault.series.application.ports.out.SeriesCatalogPort;
import com.dizio1.watchvault.series.domain.exception.SeriesNotFoundException;
import com.dizio1.watchvault.series.domain.model.Series;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchSeriesUseCaseImplTest {

    @Mock
    private SeriesCatalogPort seriesCatalog;
    @InjectMocks
    private SearchSeriesUseCaseImpl searchSeriesUseCase;

    @Test
    public void searchByTitle_givenNonExistingSeries_returnsSeries() {
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

        Series result = searchSeriesUseCase.searchByTitle(series.getTitle());

        assertEquals(series.getId(), result.getId());
        assertEquals(series.getTitle(), result.getTitle());
        assertEquals(series.getEpisodes(), result.getEpisodes());
        assertEquals(series.getGenres(), result.getGenres());
        assertEquals(series.getCreatedBy(), result.getCreatedBy());
        assertEquals(series.getFirstAirDate(), result.getFirstAirDate());
        assertEquals(series.getLastAirDate(), result.getLastAirDate());
        assertEquals(series.getOverview(), result.getOverview());
        assertEquals(series.getSeasons(), result.getSeasons());
        assertEquals(series.getStatus(), result.getStatus());

        verify(seriesCatalog).searchByTitle(series.getTitle());
    }

    @Test
    public void searchByTitle_givenNonExistingSeries_throwsSeriesNotFoundException() {
        String title = "The Godfather";

        when(searchSeriesUseCase.searchByTitle(title)).thenThrow(SeriesNotFoundException.class);

        assertThrows(SeriesNotFoundException.class, () -> searchSeriesUseCase.searchByTitle(title));

        verify(seriesCatalog).searchByTitle(title);
    }
}
