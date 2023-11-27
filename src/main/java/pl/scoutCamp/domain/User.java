package pl.scoutCamp.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "firstName", "lastName"})
public class User {

    Integer id;
    String firstName;
    String lastName;
}
