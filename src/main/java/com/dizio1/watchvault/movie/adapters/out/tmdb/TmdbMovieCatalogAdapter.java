package com.dizio1.watchvault.movie.adapters.out.tmdb;

import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.adapters.out.tmdb.dto.SearchMoviesIdResult;
import com.dizio1.watchvault.movie.domain.Movie;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TmdbMovieCatalogAdapter implements MovieCatalogPort {

    private final RestClient tmdb;

    public TmdbMovieCatalogAdapter(RestClient restClient) {
        this.tmdb = restClient;
    }

    @Override
    public SearchMoviesIdResult searchMovieId(String query) {
        return tmdb.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/movie")
                        .queryParam("query", query)
                        .queryParam("include_adult", true)
                        .build())
                .retrieve()
                .body(SearchMoviesIdResult.class);
    }

    @Override
    public Movie getMovieDetails(Long id) {
        return tmdb.get()
                .uri("/movie/{id}", id)
                .retrieve()
                .body(Movie.class);
    }

}
