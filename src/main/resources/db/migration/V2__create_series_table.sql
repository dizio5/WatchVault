CREATE TABLE series
(
    id             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title          VARCHAR(255),
    description    TEXT NOT NULL,
    created_by     VARCHAR(255),
    episodes       INT,
    seasons        INT,
    first_air_date DATE,
    last_air_date  DATE,
    status         VARCHAR(255)
);