package pl.scoutCamp.domain;

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
