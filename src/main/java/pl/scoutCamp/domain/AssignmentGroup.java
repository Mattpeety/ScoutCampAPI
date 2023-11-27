package pl.scoutCamp.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "ordered"})
public class AssignmentGroup {

    Integer id;
    String name;
    Integer ordered;
}
