package pl.scoutCamp.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name"})
public class Regiment {

    Integer id;
    String name;
}
