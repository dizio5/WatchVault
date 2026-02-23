package com.dizio1.watchvault.review.domain;

public enum ShowType {

    SERIES,
    MOVIE,
    ANIME;

    public static ShowType from(String value) {
        try {
            return ShowType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
