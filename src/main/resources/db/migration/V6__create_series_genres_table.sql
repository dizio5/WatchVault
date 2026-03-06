CREATE TABLE series_genres
(
    series_id BIGINT NOT NULL,
    genre_id  BIGINT NOT NULL,

    PRIMARY KEY (series_id, genre_id),

    CONSTRAINT fk_series_genres_series
        FOREIGN KEY (series_id)
            REFERENCES series (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_series_genres_genres
        FOREIGN KEY (genre_id)
            REFERENCES genres (id)
            ON DELETE CASCADE
)