package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.exception.TeamCategorizationSheet;
import pl.scoutCamp.infrastructure.database.entity.TeamCategorizationSheetEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamCategorizationSheetEntityMapper {

    TeamCategorizationSheet mapFromEntity (TeamCategorizationSheetEntity teamCategorizationSheet);
}
