CREATE TABLE troop
(
    troop_id        SERIAL      NOT NULL,
    regiment_id     INT         NOT NULL,
    name            VARCHAR(64) NOT NULL,
    PRIMARY KEY (troop_id),
    CONSTRAINT fk_regiment_troop
        FOREIGN KEY (regiment_id)
            REFERENCES regiment (regiment_id)
);