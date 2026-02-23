package com.dizio1.watchvault.movie.infraestructure.in.web;

import com.dizio1.watchvault.movie.application.ports.in.SearchCrewMembersUseCase;
import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.domain.model.CrewMember;
import com.dizio1.watchvault.movie.domain.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final SearchMovieUseCase searchMovieUseCase;
    private final SearchCrewMembersUseCase searchCrewMembersUseCase;
    private final RestMovieMapper movieMapper;

    public MovieController(SearchMovieUseCase searchMovieUseCase,
                           SearchCrewMembersUseCase searchCrewMembersUseCase,
                           RestMovieMapper movieMapper) {
        this.searchMovieUseCase = searchMovieUseCase;
        this.movieMapper = movieMapper;
        this.searchCrewMembersUseCase = searchCrewMembersUseCase;
    }

    @GetMapping("/search")
    public MovieResponse getMovieId(@RequestParam String name) {
        Movie movie = searchMovieUseCase.getMovieDetails(name);
        return movieMapper.fromModelToResponse(movie);
    }

    @GetMapping("/crew")
    public Page<CrewMember> getMovieCrew(@RequestParam String name,
                                         @PageableDefault Pageable pageable) {

    }
}
