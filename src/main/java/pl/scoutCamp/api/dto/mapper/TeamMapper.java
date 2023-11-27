package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.TeamDTO;
import pl.scoutCamp.domain.Team;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamDTO map (Team team);
}
