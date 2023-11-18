package pl.scoutCamp.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "userId")
@ToString(of = {"userId", "firstName", "lastName"})
public class User {

    Integer userId;
    String firstName;
    String lastName;
}
