package pl.scoutCamp.api.dto.dtoList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.scoutCamp.api.dto.TeamCategorizationSheetAssignmentDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamCategorizationSheetAssignmentsDTO {

    private List<TeamCategorizationSheetAssignmentDTO> teamCategorizationSheetAssignmentsDTO;
}
