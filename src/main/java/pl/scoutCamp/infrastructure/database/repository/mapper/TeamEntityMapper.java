package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.Team;
import pl.scoutCamp.infrastructure.database.entity.TeamEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamEntityMapper {

    Team mapFromEntity(TeamEntity team);
}
