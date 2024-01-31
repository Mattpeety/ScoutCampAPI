package pl.scoutCamp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDTO {

    Integer id;
    String assignmentType;
    String description;
    Integer maxPoints;
    Integer maxScoringValue;
    CategorizationSheetDTO categorizationSheet;
    CategoryDTO category;
    Set<AssignmentGroupDTO> assignmentGroups;
}
