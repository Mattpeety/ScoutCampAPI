package pl.scoutCamp.util;

import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;

public class RegimentEntityFixtures {

    public static RegimentEntity someRegiment1(){
        return RegimentEntity.builder()
                .name("someRegiment1")
                .build();
    }

    public static RegimentEntity someRegiment2(){
        return RegimentEntity.builder()
                .name("someRegiment2")
                .build();
    }

    public static RegimentEntity someRegiment3(){
        return RegimentEntity.builder()
                .name("someRegiment3")
                .build();
    }

}
