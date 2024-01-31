package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.TeamCategorizationSheetAssignmentDTO;
import pl.scoutCamp.domain.TeamCategorizationSheetAssignment;

@Mapper(componentModel = "spring")
public interface TeamCategorizationSheetAssignmentMapper {

    TeamCategorizationSheetAssignment map (TeamCategorizationSheetAssignmentDTO teamCategorizationSheetAssignmentDTO);
}
