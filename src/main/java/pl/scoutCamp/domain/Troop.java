package pl.scoutCamp.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "troopId")
@ToString(of = {"troopId", "name", "regiment"})
public class Troop {

    Integer troopId;
    String name;
    Regiment regiment;
}