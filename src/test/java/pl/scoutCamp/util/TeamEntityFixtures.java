package pl.scoutCamp.util;

import lombok.experimental.UtilityClass;
import pl.scoutCamp.infrastructure.database.entity.TeamEntity;

import static pl.scoutCamp.util.RegimentEntityFixtures.someRegiment1;
import static pl.scoutCamp.util.TroopEntityFixtures.someTroop1;
import static pl.scoutCamp.util.TroopEntityFixtures.someTroop2;
import static pl.scoutCamp.util.UserEntityFixtures.*;

@UtilityClass
public class TeamEntityFixtures {

    public static TeamEntity someTeam1() {
        return TeamEntity.builder()
                .id(1)
                .user(someUser1())
                .regiment(someRegiment1())
                .troop(someTroop1())
                .name("Pierwsza testowa drużyna")
                .build();
    }

    public static TeamEntity someTeam2() {
        return TeamEntity.builder()
                .id(2)
                .user(someUser2())
                .regiment(someRegiment1())
                .troop(someTroop1())
                .name("Pierwsza testowa drużyna")
                .build();
    }

    public static TeamEntity someTeam3() {
        return TeamEntity.builder()
                .id(3)
                .user(someUser3())
                .regiment(someRegiment1())
                .troop(someTroop2())
                .name("Pierwsza testowa drużyna")
                .build();
    }
}
