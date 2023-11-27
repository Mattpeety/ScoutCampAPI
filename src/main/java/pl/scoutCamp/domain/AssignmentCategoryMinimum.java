package pl.scoutCamp.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "category", "assignment"})
public class AssignmentCategoryMinimum {

    Integer id;
    Category category;
    Assignment assignment;
}
