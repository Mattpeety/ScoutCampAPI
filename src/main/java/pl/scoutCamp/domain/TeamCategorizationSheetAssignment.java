package pl.scoutCamp.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "isCompleted",
        "amount", "assignment", "teamCategorizationSheet"})
public class TeamCategorizationSheetAssignment {

    Integer id;
    Boolean isCompleted;
    Integer amount;
    Assignment assignment;
    TeamCategorizationSheet teamCategorizationSheet;
}
