package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.TeamCategorizationSheetAssignment;
import pl.scoutCamp.infrastructure.database.entity.TeamCategorizationSheetAssignmentEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamCategorizationSheetAssignmentEntityMapper {

    TeamCategorizationSheetAssignment mapFromEntity(
            TeamCategorizationSheetAssignmentEntity teamCategorizationSheetAssignment
    );

    TeamCategorizationSheetAssignmentEntity mapToEntity(TeamCategorizationSheetAssignment teamSheet);
}
