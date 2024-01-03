package pl.scoutCamp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamCategorizationSheetDTO {

    Integer id;
    Boolean isDraft;
    Integer points;
    Timestamp createdAt;
    Timestamp updatedAt;
    CategorizationSheetDTO categorizationSheet;
    TeamDTO team;
    CategoryDTO category;
}
