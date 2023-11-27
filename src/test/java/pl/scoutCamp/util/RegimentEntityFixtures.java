package pl.scoutCamp.util;

<<<<<<< Updated upstream
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;

=======
import lombok.With;
import lombok.experimental.UtilityClass;
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;

@UtilityClass
>>>>>>> Stashed changes
public class RegimentEntityFixtures {

    public static RegimentEntity someRegiment1(){
        return RegimentEntity.builder()
<<<<<<< Updated upstream
=======
                .id(1)
>>>>>>> Stashed changes
                .name("someRegiment1")
                .build();
    }

    public static RegimentEntity someRegiment2(){
        return RegimentEntity.builder()
<<<<<<< Updated upstream
=======
                .id(2)
>>>>>>> Stashed changes
                .name("someRegiment2")
                .build();
    }

    public static RegimentEntity someRegiment3(){
        return RegimentEntity.builder()
<<<<<<< Updated upstream
=======
                .id(3)
>>>>>>> Stashed changes
                .name("someRegiment3")
                .build();
    }

}
