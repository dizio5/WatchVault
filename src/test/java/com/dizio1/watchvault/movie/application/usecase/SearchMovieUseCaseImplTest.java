package com.dizio1.watchvault.movie.application.usecase;

import com.dizio1.watchvault.genre.domain.model.Genre;
import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.domain.model.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchMovieUseCaseImplTest {
    @Mock
    private MovieCatalogPort movieCatalog;
    @InjectMocks
    private SearchMovieUseCaseImpl searchMovieUseCaseImpl;

    @Test
    public void searchMovie_givenExistingMovie_returnsMovieWithDirector() {
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setDirectedBy("Quentin Tarantino");
        movie.setGenres(List.of(new Genre(1L, "Drama"), new Genre(2L, "Comedy")));
        movie.setRuntime(121);
        movie.setReleaseDate(LocalDate.of(2009, 11, 20));
        movie.setOverview("Uma Thurman feet");
        movie.setTitle("Pulp Fiction");

        CrewMember tarantino = new CrewMember(1L,
                "Quentin Tarantino",
                1,
                "Director",
                "Directing");
        CrewMember crewMember = new CrewMember(2L,
                "John Doe",
                1,
                "Make up",
                "Make Up Artist");

        when(movieCatalog.searchByTitle(movie.getTitle())).thenReturn(movie);
        when(movieCatalog.searchCrewMembers(movie.getTitle())).thenReturn(List.of(tarantino, crewMember));

        Movie result = searchMovieUseCaseImpl.searchMovie(movie.getTitle());

        assertEquals(movie.getTitle(), result.getTitle());
        assertEquals(movie.getDirectedBy(), result.getDirectedBy());
        assertEquals(movie.getGenres(), result.getGenres());
        assertEquals(movie.getId(), result.getId());
        assertEquals(movie.getReleaseDate(), result.getReleaseDate());
        assertEquals(movie.getOverview(), result.getOverview());
        assertEquals(movie.getRuntime(), result.getRuntime());

        verify(movieCatalog).searchCrewMembers(movie.getTitle());
        verify(movieCatalog).searchByTitle(movie.getTitle());
    }
}
