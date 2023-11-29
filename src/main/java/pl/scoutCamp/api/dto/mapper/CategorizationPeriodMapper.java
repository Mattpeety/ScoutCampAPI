package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.CategorizationPeriodDTO;
import pl.scoutCamp.domain.CategorizationPeriod;

@Mapper(componentModel = "spring")
public interface CategorizationPeriodMapper {

    CategorizationPeriodDTO map(CategorizationPeriod categorizationPeriod);
}
