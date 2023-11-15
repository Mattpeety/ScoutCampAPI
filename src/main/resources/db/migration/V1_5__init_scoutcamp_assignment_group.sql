CREATE TABLE assignment_group
(
    assignment_group_id     SERIAL      NOT NULL,
    name                    VARCHAR(32) NOT NULL,
    ordered                 INT         NOT NULL,
    PRIMARY KEY (assignment_group_id)
);