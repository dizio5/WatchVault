package com.dizio1.watchvault.movie.domain;

import java.time.LocalDate;
import java.util.List;

public class Movie {

    private Long id;
    private String originalTitle;
    private String overview;
    private int runtime;
    private LocalDate releaseDate;
    private boolean adult;
    private List<Genre> genres;
}
