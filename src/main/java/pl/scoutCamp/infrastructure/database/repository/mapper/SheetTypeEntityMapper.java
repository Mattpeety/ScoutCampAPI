package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.SheetType;
import pl.scoutCamp.infrastructure.database.entity.SheetTypeEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SheetTypeEntityMapper {

    SheetType mapFromEntity(SheetTypeEntity sheetType);
}
