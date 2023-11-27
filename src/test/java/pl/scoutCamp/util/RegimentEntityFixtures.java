package pl.scoutCamp.util;

import lombok.experimental.UtilityClass;
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;

@UtilityClass
public class RegimentEntityFixtures {

    public static RegimentEntity someRegiment1(){
        return RegimentEntity.builder()
                .id(1)
                .name("someRegiment1")
                .build();
    }

    public static RegimentEntity someRegiment2(){
        return RegimentEntity.builder()
                .id(2)
                .name("someRegiment2")
                .build();
    }

    public static RegimentEntity someRegiment3(){
        return RegimentEntity.builder()
                .id(3)
                .name("someRegiment3")
                .build();
    }

}
