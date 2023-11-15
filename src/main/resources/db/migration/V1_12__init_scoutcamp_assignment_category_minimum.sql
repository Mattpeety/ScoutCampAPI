CREATE TABLE assignment_category_minimum
(
    id                  SERIAL  NOT NULL,
    assignment_id       INT     NOT NULL,
    category_id         INT     NOT NULL,
    minimum_value       INT     NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_assignment_assignment_minimum_assignment
        FOREIGN KEY (assignment_id)
            REFERENCES assignment (assignment_id),
    CONSTRAINT fk_assignment_assignment_minimum_category
        FOREIGN KEY (category_id)
            REFERENCES category (category_id)
);