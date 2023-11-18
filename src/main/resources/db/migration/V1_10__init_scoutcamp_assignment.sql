CREATE TABLE assignment
(
    assignment_id               SERIAL          NOT NULL,
    category_id                 INT             NOT NULL,
    categorization_sheet_id     INT             NOT NULL,
    assignment_group_id         INT             NOT NULL,
    assignment_type             VARCHAR(32)     NOT NULL,
    description                 TEXT            NOT NULL,
    max_points                  INT             NOT NULL,
    max_scoring_value           INT             NOT NULL,
    PRIMARY KEY (assignment_id),
    CONSTRAINT fk_assignment_category
        FOREIGN KEY (category_id)
            REFERENCES category (category_id),
    CONSTRAINT fk_assignment_categorization_sheet
        FOREIGN KEY (categorization_sheet_id)
            REFERENCES categorization_sheet (categorization_sheet_id),
    CONSTRAINT fk_assignment_assignment_group
        FOREIGN KEY (assignment_group_id)
            REFERENCES assignment_group (assignment_group_id)
);