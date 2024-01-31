package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.AssignmentDTO;
import pl.scoutCamp.domain.Assignment;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {

    Assignment map (AssignmentDTO assignmentDTO);
}
