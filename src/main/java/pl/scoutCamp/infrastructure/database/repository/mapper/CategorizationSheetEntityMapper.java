package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.exception.CategorizationSheet;
import pl.scoutCamp.infrastructure.database.entity.CategorizationSheetEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategorizationSheetEntityMapper {

    CategorizationSheet mapFromEntity(CategorizationSheetEntity categorizationSheet);
}
