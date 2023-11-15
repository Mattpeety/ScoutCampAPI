CREATE TABLE team
(
    team_id         SERIAL      NOT NULL,
    troop_id        INT         NOT NULL,
    regiment_id     INT         NOT NULL,
    user_id         INT         NOT NULL,
    name            VARCHAR(64) NOT NULL,
    PRIMARY KEY (team_id),
    CONSTRAINT fk_team_troop
        FOREIGN KEY (troop_id)
            REFERENCES troop (troop_id),
    CONSTRAINT fk_team_regiment
        FOREIGN KEY (regiment_id)
            REFERENCES regiment (regiment_id),
    CONSTRAINT fk_team_user
        FOREIGN KEY (user_id)
             REFERENCES scoutcamp_user (user_id)
);