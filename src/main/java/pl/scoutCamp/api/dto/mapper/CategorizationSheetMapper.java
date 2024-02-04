package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.CategorizationSheetDTO;
import pl.scoutCamp.domain.CategorizationSheet;

@Mapper(componentModel = "spring")
public interface CategorizationSheetMapper {

    CategorizationSheetDTO map (CategorizationSheet categorizationSheet);
}
