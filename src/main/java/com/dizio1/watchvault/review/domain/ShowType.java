package com.dizio1.watchvault.review.domain;

import java.util.Arrays;

public enum ShowType {

    SERIES("Series"),
    MOVIE("Movie"),
    ANIME("Anime");

    private final String name;

    ShowType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static ShowType from(String value) {
        return Arrays.stream(ShowType.values())
                .filter(t -> t.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
