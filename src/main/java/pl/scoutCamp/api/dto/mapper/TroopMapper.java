<<<<<<< Updated upstream
package pl.scoutCamp.api.dto.mapper;public interface TroopMapper {
=======
package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.TroopDTO;
import pl.scoutCamp.domain.Troop;

@Mapper(componentModel = "spring")
public interface TroopMapper{

    TroopDTO map(Troop troop);
>>>>>>> Stashed changes
}
