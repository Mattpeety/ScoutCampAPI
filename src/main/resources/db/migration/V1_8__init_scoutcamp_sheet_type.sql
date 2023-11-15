CREATE TABLE sheet_type
(
    sheet_type_id           SERIAL      NOT NULL,
    name                    VARCHAR(32) NOT NULL,
    ordered                 INT         NOT NULL,
    is_scored_sheet         BOOLEAN     NOT NULL,
    PRIMARY KEY (sheet_type_id)
);