CREATE TABLE team_categorization_sheet_assignment
(
    team_categorization_sheet_assignment_id SERIAL NOT NULL,
    assignment_id                           INT NOT NULL,
    team_categorization_sheet_id            INT NOT NULL,
    is_completed                            BOOLEAN,
    amount                                  INT,
    PRIMARY KEY (team_categorization_sheet_assignment_id),
    CONSTRAINT fk_team_categorization_sheet_assignment_assignment
            FOREIGN KEY (assignment_id)
                REFERENCES assignment (assignment_id),
    CONSTRAINT fk_team_categorization_sheet_assignment_team_categorization_sheet
            FOREIGN KEY (team_categorization_sheet_id)
                REFERENCES team_categorization_sheet (team_categorization_sheet_id)
);