CREATE TABLE movies
(
    id           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title        VARCHAR(255) NOT NULL UNIQUE,
    directed_by  VARCHAR(255),
    overview     TEXT,
    runtime      INT,
    release_date DATE
);