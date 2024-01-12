package pl.scoutCamp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RankingDTO {

    String teamName;
    Integer totalPoints;
    String category;
    List<TeamCategorizationSheetDTO> sheets;
}
