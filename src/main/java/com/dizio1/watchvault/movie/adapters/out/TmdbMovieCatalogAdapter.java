package com.dizio1.watchvault.movie.adapters.out;

import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.adapters.out.dto.SearchMoviesResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TmdbMovieCatalogAdapter implements MovieCatalogPort {

    private final RestClient tmdb;

    public TmdbMovieCatalogAdapter(RestClient restClient) {
        this.tmdb = restClient;
    }

    @Override
    public SearchMoviesResult searchMovie(String query) {
        return tmdb.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/movie")
                        .queryParam("query", query)
                        .queryParam("include_adult", true)
                        .build())
                .retrieve()
                .body(SearchMoviesResult.class);
    }
}
