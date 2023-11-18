package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.AssignmentGroup;
import pl.scoutCamp.infrastructure.database.entity.AssignmentGroupEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignmentGroupEntityMapper {

    AssignmentGroup mapFromEntity(AssignmentGroupEntity assignmentGroup);
}
