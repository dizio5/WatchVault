package com.dizio1.watchvault.movie.infraestructure.out.tmdb;

import com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.*;
import com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.mapper.TmdbCastMapper;
import com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.mapper.TmdbMovieMapper;
import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.domain.exception.MovieNotFoundException;
import com.dizio1.watchvault.movie.domain.model.CastMember;
import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Component
public class TmdbMovieCatalogAdapter implements MovieCatalogPort {

    private final RestClient tmdb;
    private final TmdbMovieMapper tmdbMovieMapper;
    private final TmdbCastMapper tmdbCastMapper;

    public TmdbMovieCatalogAdapter(RestClient restClient,
                                   TmdbMovieMapper tmdbMovieMapper,
                                   TmdbCastMapper tmdbCastMapper) {
        this.tmdb = restClient;
        this.tmdbMovieMapper = tmdbMovieMapper;
        this.tmdbCastMapper = tmdbCastMapper;
    }

    @Override
    public Long searchMovieId(String query) {
        SearchMoviesIdResult response = tmdb.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/movie")
                        .queryParam("query", query)
                        .queryParam("include_adult", true)
                        .build())
                .retrieve()
                .body(SearchMoviesIdResult.class);
        if (response == null) {
            throw new MovieNotFoundException(query);
        }
        return response.results().getFirst().id();
    }

    @Override
    public Movie getMovieDetails(Long id) {
        TmdbMovieResponse response = tmdb.get()
                .uri("/movie/{id}", id)
                .retrieve()
                .body(TmdbMovieResponse.class);
        return tmdbMovieMapper.toModel(Objects.requireNonNull(response));
    }

    @Override
    public List<CastMember> searchMovieCastMembers(Long id) {
        SearchCastResult response = tmdb.get()
                .uri("/movie/{id}/credits", id)
                .retrieve()
                .body(SearchCastResult.class);

        return Objects.requireNonNull(response).cast()
                .stream()
                .sorted(Comparator.comparing(SearchCastDTO::popularity).reversed())
                .map(tmdbCastMapper::toModel)
                .toList();
    }

    @Override
    public List<CrewMember> searchMovieCrewMembers(Long id) {
        SearchCrewResult response =  tmdb.get()
                .uri("/movie/{id}/credits", id)
                .retrieve()
                .body(SearchCrewResult.class);
        return Objects.requireNonNull(response).crew();
    }
}
