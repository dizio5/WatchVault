package com.dizio1.watchvault.movie.infrastructure.config;

import com.dizio1.watchvault.movie.application.ports.in.SearchCastMembersUseCase;
import com.dizio1.watchvault.movie.application.ports.in.SearchCrewMembersUseCase;
import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.application.ports.out.MovieCatalogPort;
import com.dizio1.watchvault.movie.application.usecase.SearchCastMembersUseCaseImpl;
import com.dizio1.watchvault.movie.application.usecase.SearchCrewMembersUseCaseImpl;
import com.dizio1.watchvault.movie.application.usecase.SearchMovieUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieApplicationConfig {

    @Bean
    SearchMovieUseCase searchMovieUseCase(MovieCatalogPort movieCatalogPort) {
        return new SearchMovieUseCaseImpl(movieCatalogPort);
    }

    @Bean
    SearchCrewMembersUseCase searchCrewMembersUseCase(MovieCatalogPort movieCatalogPort) {
        return new SearchCrewMembersUseCaseImpl(movieCatalogPort);
    }

    @Bean
    SearchCastMembersUseCase searchCastMembersUseCase(MovieCatalogPort movieCatalogPort) {
        return new SearchCastMembersUseCaseImpl(movieCatalogPort);
    }
}
