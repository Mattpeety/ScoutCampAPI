CREATE TABLE categorization_sheet
(
    categorization_sheet_id     SERIAL  NOT NULL,
    categorization_period_id    INT     NOT NULL,
    sheet_type_id               INT     NOT NULL,
    PRIMARY KEY (categorization_sheet_id),
    CONSTRAINT fk_categorization_sheet_period
        FOREIGN KEY (categorization_period_id)
            REFERENCES categorization_period (categorization_period_id),
    CONSTRAINT fk_categorization_sheet_sheet_type
        FOREIGN KEY (sheet_type_id)
            REFERENCES sheet_type (sheet_type_id)
);