package com.dizio1.watchvault.movie.infraestructure.in;

import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final SearchMovieUseCase searchMovieUseCase;

    public MovieController(SearchMovieUseCase searchMovieUseCase) {
        this.searchMovieUseCase = searchMovieUseCase;
    }

    @GetMapping("/search")
    public Movie getMovieId(@RequestParam String name) {
        return searchMovieUseCase.getMovieDetails(name);
    }
}
