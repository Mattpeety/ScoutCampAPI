CREATE TABLE scoutcamp_user
(
    user_id         SERIAL      NOT NULL,
    first_name      VARCHAR(32) NOT NULL,
    last_name       VARCHAR(32) NOT NULL,
    PRIMARY KEY (user_id)
);