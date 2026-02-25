package com.dizio1.watchvault.series.domain.exception;

public class SeriesNotFoundException extends RuntimeException {
    public SeriesNotFoundException(String message) {
        super("Series: " +  message + " not found.");
    }
}
