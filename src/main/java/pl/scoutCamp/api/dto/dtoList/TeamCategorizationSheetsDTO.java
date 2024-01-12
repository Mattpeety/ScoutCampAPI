package pl.scoutCamp.api.dto.dtoList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import pl.scoutCamp.api.dto.TeamCategorizationSheetDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamCategorizationSheetsDTO {
    private List<TeamCategorizationSheetDTO> teamCategorizationSheets;
    private Page<TeamCategorizationSheetDTO> teamCategorizationSheetsPage;
}
