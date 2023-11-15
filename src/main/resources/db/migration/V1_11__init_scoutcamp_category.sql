CREATE TABLE category
(
    category_id     SERIAL          NOT NULL,
    name            VARCHAR(16)     NOT NULL,
    image_path      TEXT            NOT NULL,
    PRIMARY KEY (category_id)
);