package com.dizio1.watchvault.movie.application.ports.out;

import com.dizio1.watchvault.movie.adapters.out.dto.SearchMoviesResult;

public interface MovieCatalogPort {

    SearchMoviesResult searchMovie(String query);
}
