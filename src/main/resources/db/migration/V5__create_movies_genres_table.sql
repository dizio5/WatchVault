CREATE TABLE movies_genres
(
    movie_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,

    PRIMARY KEY (movie_id, genre_id),

    CONSTRAINT fk_movies_genres_movie
        FOREIGN KEY (movie_id)
            REFERENCES movies (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_movies_genres_genre
        FOREIGN KEY (genre_id)
            REFERENCES genres (id)
            ON DELETE CASCADE
);