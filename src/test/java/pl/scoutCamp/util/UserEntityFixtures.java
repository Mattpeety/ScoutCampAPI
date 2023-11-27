package pl.scoutCamp.util;

import lombok.experimental.UtilityClass;
import pl.scoutCamp.infrastructure.database.entity.UserEntity;

@UtilityClass
public class UserEntityFixtures {

    public static UserEntity someUser1() {
        return UserEntity.builder()
                .id(1)
                .firstName("Adam")
                .lastName("Kowalski")
                .build();
    }

    public static UserEntity someUser2() {
        return UserEntity.builder()
                .id(2)
                .firstName("Jacek")
                .lastName("Dąbrowski")
                .build();
    }

    public static UserEntity someUser3() {
        return UserEntity.builder()
                .id(3)
                .firstName("Kacper")
                .lastName("Malczewski")
                .build();
    }
}
