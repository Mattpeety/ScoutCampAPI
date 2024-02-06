CREATE TABLE categorization_sheet_assignment
(
    id                          SERIAL      NOT NULL,
    assignment_id               INT         NOT NULL,
    categorization_sheet_id     INT         NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_categorization_sheet_assignment_assignment
        FOREIGN KEY (assignment_id)
            REFERENCES assignment (assignment_id),
    CONSTRAINT fk_categorization_sheet_assignment_categorization_sheet
        FOREIGN KEY (categorization_sheet_id)
            REFERENCES categorization_sheet (categorization_sheet_id)
);