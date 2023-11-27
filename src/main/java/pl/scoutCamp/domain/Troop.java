package pl.scoutCamp.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "regiment"})
public class Troop {

    Integer id;
    String name;
    Regiment regiment;
}
