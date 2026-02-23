package com.dizio1.watchvault.movie.infraestructure.in.web;

import com.dizio1.watchvault.movie.application.ports.in.SearchCastMembersUseCase;
import com.dizio1.watchvault.movie.application.ports.in.SearchCrewMembersUseCase;
import com.dizio1.watchvault.movie.application.ports.in.SearchMovieUseCase;
import com.dizio1.watchvault.movie.domain.model.Movie;
import com.dizio1.watchvault.movie.infraestructure.in.web.dto.CastResponse;
import com.dizio1.watchvault.movie.infraestructure.in.web.dto.CrewResponse;
import com.dizio1.watchvault.movie.infraestructure.in.web.dto.MovieResponse;
import com.dizio1.watchvault.movie.infraestructure.in.web.dto.mapper.RestCastMapper;
import com.dizio1.watchvault.movie.infraestructure.in.web.dto.mapper.RestCrewMapper;
import com.dizio1.watchvault.movie.infraestructure.in.web.dto.mapper.RestMovieMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final SearchMovieUseCase searchMovieUseCase;
    private final SearchCrewMembersUseCase searchCrewMembersUseCase;
    private final SearchCastMembersUseCase searchCastMembersUseCase;
    private final RestMovieMapper movieMapper;
    private final RestCastMapper castMapper;
    private final RestCrewMapper crewMapper;

    public MovieController(SearchMovieUseCase searchMovieUseCase,
                           SearchCrewMembersUseCase searchCrewMembersUseCase,
                           SearchCastMembersUseCase searchCastMembersUseCase,
                           RestMovieMapper movieMapper,
                           RestCastMapper castMapper,
                           RestCrewMapper crewMapper) {
        this.searchMovieUseCase = searchMovieUseCase;
        this.searchCrewMembersUseCase = searchCrewMembersUseCase;
        this.searchCastMembersUseCase = searchCastMembersUseCase;
        this.movieMapper = movieMapper;
        this.castMapper = castMapper;
        this.crewMapper = crewMapper;
    }

    @GetMapping("/search")
    public MovieResponse getMovieId(@RequestParam String name) {
        Movie movie = searchMovieUseCase.getMovieDetails(name);
        return movieMapper.fromModelToResponse(movie);
    }

    @GetMapping("/crew")
    public Page<CrewResponse> getMovieCrew(@RequestParam String name,
                                           @PageableDefault Pageable pageable) {
        List<CrewResponse> crewMembers = searchCrewMembersUseCase.getCrewMembers(name)
                .stream()
                .map(crewMapper::toResponse)
                .toList();

        return paginate(crewMembers, pageable);
    }

    @GetMapping("/cast")
    public Page<CastResponse> getMovieCast(@RequestParam String name,
                                           @PageableDefault Pageable pageable) {
        List<CastResponse> castMembers = searchCastMembersUseCase.getCastMembers(name)
                .stream()
                .map(castMapper::toResponse)
                .toList();

        return paginate(castMembers, pageable);
    }

    private <T> Page<T> paginate(List<T> list, Pageable pageable) {
        int start = Math.toIntExact(pageable.getOffset());
        int end = Math.min(start + pageable.getPageSize(), list.size());
        List<T> pagedList = list.subList(start, end);

        return new PageImpl<>(pagedList, pageable, list.size());
    }
}
