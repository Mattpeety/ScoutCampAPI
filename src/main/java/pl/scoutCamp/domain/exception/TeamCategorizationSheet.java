package pl.scoutCamp.domain.exception;

import lombok.*;

import java.sql.Timestamp;

@With
@Value
@Builder
@EqualsAndHashCode(of = "teamCategorizationSheetId")
@ToString(of = {"teamCategorizationSheetId", "isDraft", "points", "createdAt",
        "updatedAt", "categorizationSheet", "team", "category"})
public class TeamCategorizationSheet {

    Integer teamCategorizationSheetId;
    Boolean isDraft;
    Integer points;
    Timestamp createdAt;
    Timestamp updatedAt;
    CategorizationSheet categorizationSheet;
    Team team;
    Category category;
}
