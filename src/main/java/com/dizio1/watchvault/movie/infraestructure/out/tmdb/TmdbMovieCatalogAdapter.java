package com.dizio1.watchvault.movie.infraestructure.out.tmdb;

import com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.*;
import com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.mapper.CastMapper;
import com.dizio1.watchvault.movie.infraestructure.out.tmdb.dto.mapper.MovieMapper;
import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.domain.exception.MovieNotFoundException;
import com.dizio1.watchvault.movie.domain.model.CastMember;
import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;

@Component
public class TmdbMovieCatalogAdapter implements MovieCatalogPort {

    private final RestClient tmdb;
    private final MovieMapper movieMapper;
    private final CastMapper castMapper;

    public TmdbMovieCatalogAdapter(RestClient restClient,
                                   MovieMapper movieMapper,
                                   CastMapper castMapper) {
        this.tmdb = restClient;
        this.movieMapper = movieMapper;
        this.castMapper = castMapper;
    }

    @Override
    public SearchMoviesIdResult searchMovieId(String query) {
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
        return response;
    }

    @Override
    public Movie getMovieDetails(Long id) {
        TmdbMovieResponse response = tmdb.get()
                .uri("/movie/{id}", id)
                .retrieve()
                .body(TmdbMovieResponse.class);
        return movieMapper.fromResponseToModel(Objects.requireNonNull(response));
    }

    @Override
    public List<CastMember> searchMovieCastMembers(Long id) {
        SearchCastResult response = tmdb.get()
                .uri("/movie/{id}/credits", id)
                .retrieve()
                .body(SearchCastResult.class);

        return Objects.requireNonNull(response).cast()
                .stream()
                .filter(searchCastDTO -> searchCastDTO.order() <= 20)
                .filter(searchCastDTO -> searchCastDTO.popularity() > 5)
                .limit(10)
                .map(castMapper::fromResponseToModel)
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
