package pl.scoutCamp.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.scoutCamp.domain.exception.CategorizationPeriod;
import pl.scoutCamp.infrastructure.database.entity.CategorizationPeriodEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategorizationPeriodEntityMapper {

    CategorizationPeriod mapFromEntity(CategorizationPeriodEntity categorizationPeriod);
}
