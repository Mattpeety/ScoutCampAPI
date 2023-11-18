package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.Regiment;
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegimentEntityMapper {

    Regiment mapFromEntity(RegimentEntity regiment);
}
