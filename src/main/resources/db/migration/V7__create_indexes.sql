-- Many to many
CREATE INDEX idx_movies_genres_movie
    ON movies_genres (movie_id);

CREATE INDEX idx_series_genres_series
    ON series_genres (series_id);
