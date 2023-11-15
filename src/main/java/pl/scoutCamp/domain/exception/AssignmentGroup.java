package pl.scoutCamp.domain.exception;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "assignmentGroupId")
@ToString(of = {"assignmentGroupId", "name", "ordered"})
public class AssignmentGroup {

    Integer assignmentGroupId;
    String name;
    Integer ordered;
}
