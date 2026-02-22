package com.dizio1.watchvault.movie.domain.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String message) {
        super("Movie: " + message + " not found.");
    }
}
