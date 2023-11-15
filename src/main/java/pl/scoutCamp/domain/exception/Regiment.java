package pl.scoutCamp.domain.exception;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "regimentId")
@ToString(of = {"regimentId", "name"})
public class Regiment {

    Integer regimentId;
    String name;
}
