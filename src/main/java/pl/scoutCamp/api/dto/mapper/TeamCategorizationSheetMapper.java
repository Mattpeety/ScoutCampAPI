package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.TeamCategorizationSheetDTO;
import pl.scoutCamp.domain.TeamCategorizationSheet;

@Mapper(componentModel = "spring")
public interface TeamCategorizationSheetMapper {

    TeamCategorizationSheetDTO map(TeamCategorizationSheet teamCategorizationSheet);

    TeamCategorizationSheet map (TeamCategorizationSheetDTO teamCategorizationSheetDTO);
}
