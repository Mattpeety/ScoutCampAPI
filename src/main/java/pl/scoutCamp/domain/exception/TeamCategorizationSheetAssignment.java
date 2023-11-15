package pl.scoutCamp.domain.exception;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "teamCategorizationSheetAssignmentId")
@ToString(of = {"teamCategorizationSheetAssignmentId", "isCompleted",
        "amount", "assignment", "teamCategorizationSheet"})
public class TeamCategorizationSheetAssignment {

    Integer teamCategorizationSheetAssignmentId;
    Boolean isCompleted;
    Integer amount;
    Assignment assignment;
    TeamCategorizationSheet teamCategorizationSheet;
}
