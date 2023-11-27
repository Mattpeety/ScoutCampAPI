
package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.RegimentDTO;
import pl.scoutCamp.domain.Regiment;

@Mapper(componentModel = "spring")
public interface RegimentMapper {

    RegimentDTO map (Regiment regiment);
}
