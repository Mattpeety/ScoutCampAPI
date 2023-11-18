package pl.scoutCamp.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "assignmentCategoryMinimumId")
@ToString(of = {"assignmentCategoryMinimumId", "category", "assignment"})
public class AssignmentCategoryMinimum {

    Integer assignmentCategoryMinimumId;
    Category category;
    Assignment assignment;
}
