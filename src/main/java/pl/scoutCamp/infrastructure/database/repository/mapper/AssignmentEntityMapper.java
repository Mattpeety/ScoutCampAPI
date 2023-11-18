package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.Assignment;
import pl.scoutCamp.infrastructure.database.entity.AssignmentEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignmentEntityMapper {

    Assignment mapFromEntity(AssignmentEntity assignment);
}
