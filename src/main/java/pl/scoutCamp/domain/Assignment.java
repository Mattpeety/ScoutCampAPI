package pl.scoutCamp.domain;

import lombok.*;

import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "assignmentType", "description", "maxPoints",
                "maxScoringValue", "categorizationSheet", "category"})
public class Assignment {

    Integer id;
    String assignmentType;
    String description;
    Integer maxPoints;
    Integer maxScoringValue;
    CategorizationSheet categorizationSheet;
    Category category;
    Set<AssignmentGroup> assignmentGroups;

}
