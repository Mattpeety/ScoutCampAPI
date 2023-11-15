CREATE TABLE team_categorization_sheet
(
    team_categorization_sheet_id    SERIAL      NOT NULL,
    categorization_sheet_id         INT         NOT NULL,
    team_id                         INT         NOT NULL,
    category_id                     INT         NOT NULL,
    is_draft                        BOOLEAN     DEFAULT TRUE,
    points                          INT         NOT NULL,
    created_at                      TIMESTAMP   NOT NULL,
    updated_at                      TIMESTAMP   NOT NULL,
    PRIMARY KEY (team_categorization_sheet_id),
    CONSTRAINT fk_team_categorization_sheet_categorization_sheet
            FOREIGN KEY (categorization_sheet_id)
                REFERENCES categorization_sheet (categorization_sheet_id),
    CONSTRAINT fk_team_categorization_sheet_team
            FOREIGN KEY (team_id)
                REFERENCES team (team_id),
    CONSTRAINT fk_team_categorization_sheet_category
            FOREIGN KEY (category_id)
                REFERENCES category (category_id)
);