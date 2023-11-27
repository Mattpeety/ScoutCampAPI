package pl.scoutCamp.domain;


import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "regiment", "troop", "user"})
public class Team {

    Integer id;
    String name;
    Regiment regiment;
    Troop troop;
    User user;
}
