package pl.scoutCamp.util;

import lombok.experimental.UtilityClass;
import pl.scoutCamp.infrastructure.database.entity.UserEntity;

@UtilityClass
public class UserEntityFixtures {

    public static UserEntity someUser1() {
        return UserEntity.builder()
                .id(1)
                .userName("adam_kowalski")
                .firstName("Adam")
                .lastName("Kowalski")
                .email("adamkowalski@zhr.pl")
                .password("blebleble")
                .build();
    }

    public static UserEntity someUser2() {
        return UserEntity.builder()
                .id(2)
                .userName("jacekdabrowski")
                .firstName("Jacek")
                .lastName("Dąbrowski")
                .email("jacekdabrawski@zhr.pl")
                .password("blebleble")
                .build();
    }

    public static UserEntity someUser3() {
        return UserEntity.builder()
                .id(3)
                .userName("kacpermalczewski")
                .firstName("Kacper")
                .lastName("Malczewski")
                .email("kacpermalczewski@zhr.pl")
                .password("blebleble")
                .build();
    }
}
