CREATE TABLE assignment_group_assignment_junction
(
    id                      SERIAL          NOT NULL,
    assignment_group_id     INT             NOT NULL,
    assignment_id           INT             NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_junction_assignment_group
        FOREIGN KEY (assignment_group_id)
            REFERENCES assignment_group (assignment_group_id),
    CONSTRAINT fk_junction_assignment
            FOREIGN KEY (assignment_id)
                REFERENCES assignment (assignment_id)
);