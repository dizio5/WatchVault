CREATE TABLE reviews
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    show_id     BIGINT       NOT NULL,
    show_type   VARCHAR(20)  NOT NULL,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    rating      INT CHECK (rating BETWEEN 1 AND 10),
    reviewed_at DATE
);