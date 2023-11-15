package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.exception.AssignmentCategoryMinimum;
import pl.scoutCamp.infrastructure.database.entity.AssignmentCategoryMinimumEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignmentCategoryMinimumEntityMapper {

    AssignmentCategoryMinimum mapFromEntity(AssignmentCategoryMinimumEntity assignmentCategoryMinimum);
}
