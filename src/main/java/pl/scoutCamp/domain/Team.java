package pl.scoutCamp.domain;


import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "teamId")
@ToString(of = {"teamId", "name", "regiment", "troop", "user"})
public class Team {

    Integer teamId;
    String name;
    Regiment regiment;
    Troop troop;
    User user;
}
