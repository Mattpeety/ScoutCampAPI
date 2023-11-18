package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.Troop;
import pl.scoutCamp.infrastructure.database.entity.TroopEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TroopEntityMapper {

    Troop mapFromEntity(TroopEntity troop);
}
