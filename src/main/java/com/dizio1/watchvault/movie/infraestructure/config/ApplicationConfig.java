package com.dizio1.watchvault.movie.infraestructure.config;

import com.dizio1.watchvault.movie.application.ports.in.SearchCrewMembersUseCase;
import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.application.usecase.SearchCrewMembersUseCaseImpl;
import com.dizio1.watchvault.movie.application.usecase.SearchMovieUseCaseImpl;
import com.dizio1.watchvault.movie.infraestructure.out.tmdb.TmdbMovieCatalogAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    SearchMovieUseCase searchMovieUseCase(TmdbMovieCatalogAdapter tmdbMovieCatalogAdapter) {
        return new SearchMovieUseCaseImpl(tmdbMovieCatalogAdapter);
    }

    @Bean
    SearchCrewMembersUseCase searchCrewMembersUseCase(MovieCatalogPort movieCatalogPort) {
        return new SearchCrewMembersUseCaseImpl(movieCatalogPort);
    }
}
