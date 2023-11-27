

package pl.scoutCamp.util;

import lombok.experimental.UtilityClass;
import pl.scoutCamp.infrastructure.database.entity.TroopEntity;

import static pl.scoutCamp.util.RegimentEntityFixtures.someRegiment1;
import static pl.scoutCamp.util.RegimentEntityFixtures.someRegiment2;

@UtilityClass
public class TroopEntityFixtures {


    public static TroopEntity someTroop1() {
        return TroopEntity.builder()
                .id(1)
                .name("someTroop1")
                .regiment(someRegiment1())
                .build();
    }

    public static TroopEntity someTroop2() {
        return TroopEntity.builder()
                .id(2)
                .name("someTroop2")
                .regiment(someRegiment1())
                .build();
    }

    public static TroopEntity someTroop3() {
        return TroopEntity.builder()
                .id(3)
                .name("someTroop3")
                .regiment(someRegiment1())
                .build();
    }

    public static TroopEntity someTroop4() {
        return TroopEntity.builder()
                .id(4)
                .name("someTroop4")
                .regiment(someRegiment2())
                .build();
    }

    public static TroopEntity someTroop5() {
        return TroopEntity.builder()
                .id(5)
                .name("someTroop5")
                .regiment(someRegiment2())
                .build();
    }
    public static TroopEntity someTroop6() {
        return TroopEntity.builder()
                .id(6)
                .name("someTroop6")
                .regiment(someRegiment2())
                .build();
    }

}
