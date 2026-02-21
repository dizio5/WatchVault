package com.dizio1.watchvault.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    RestClient tmdbRestClient(
            @Value("${tmdb.base.url}") String url,
            @Value("${tmdb.token}") String token) {
        return RestClient.builder()
                .baseUrl(url)
                .defaultHeader("Authorization", "Bearer " + token)
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
