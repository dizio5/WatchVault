package com.dizio1.watchvault.review.domain;

import java.util.Arrays;

public enum ShowType {

    SERIES("Series"),
    MOVIE("Movie"),
    ANIME("Anime");

    ShowType(String name) {}

    public static ShowType from(String value) {
        return Arrays.stream(ShowType.values())
                .filter(t -> t.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
