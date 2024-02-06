package pl.scoutCamp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamCategorizationSheetAssignmentDTO {

    Integer id;
    Boolean isCompleted;
    Integer amount;
    AssignmentDTO assignment;
    TeamCategorizationSheetDTO teamCategorizationSheet;
}
