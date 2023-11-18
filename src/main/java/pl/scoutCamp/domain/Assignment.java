package pl.scoutCamp.domain;

import lombok.*;

import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "assignmentId")
@ToString(of = {"assignmentId", "assignmentType", "description", "maxPoints",
                "maxScoringValue", "categorizationSheet", "category"})
public class Assignment {

    Integer assignmentId;
    String assignmentType;
    String description;
    Integer maxPoints;
    Integer maxScoringValue;
    CategorizationSheet categorizationSheet;
    Category category;
    Set<AssignmentGroup> assignmentGroups;

}
