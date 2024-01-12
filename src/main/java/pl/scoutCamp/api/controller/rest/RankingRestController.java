package pl.scoutCamp.api.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pl.scoutCamp.api.dto.TeamCategorizationSheetDTO;
import pl.scoutCamp.api.dto.dtoList.TeamCategorizationSheetsDTO;
import pl.scoutCamp.api.dto.mapper.TeamCategorizationSheetMapper;
import pl.scoutCamp.business.TeamCategorizationSheetService;

@RestController
@AllArgsConstructor
@RequestMapping(RankingRestController.API_RANKING)
// TODO: modify response: full team data containing all of the filled categorization sheets.
public class RankingRestController {

    public static final String API_RANKING = "/ranking";
    public static final String ALL_TEAMS = "/allTeams/{period}";
    public static final String BY_REGIMENT = "/regiment={regimentId}/{periodName}/sort={sortedBy}.{order}";

    private final TeamCategorizationSheetMapper teamCategorizationSheetMapper;
    private final TeamCategorizationSheetService teamCategorizationSheetService;

    @GetMapping(value = ALL_TEAMS)
    @JsonView(JsonViews.RankingView.class)
    public TeamCategorizationSheetsDTO findAllTeamsRankingPage
            (@PathVariable String period,
             @RequestParam(required = false) Integer regiment,
             @RequestParam(defaultValue = "0") int pageNumber,
             @RequestParam(defaultValue = "50") int pageSize,
             @RequestParam(defaultValue = "points") String sort,
             @RequestParam(defaultValue = "desc") String order) {
        return getTeamCategorizationSheetsDTO(period, regiment, pageNumber, pageSize, sort, order);
    }

    private TeamCategorizationSheetsDTO getTeamCategorizationSheetsDTO(
            String period,
            Integer regimentId,
            int pageNumber,
            int pageSize,
            String sort,
            String order) {
        return TeamCategorizationSheetsDTO.builder()
                .teamCategorizationSheetsPage(getAllTeamCategorizationSheetsDTO(period, regimentId, pageNumber, pageSize, sort, order))
                .build();
    }

    private Page<TeamCategorizationSheetDTO> getAllTeamCategorizationSheetsDTO(
            String period,
            Integer regimentId,
            int pageNumber,
            int pageSize,
            String sort,
            String order) {
        return teamCategorizationSheetService.findTeamSheetsByPeriod(period, regimentId, pageNumber, pageSize, sort, order)
                .map(teamCategorizationSheetMapper::map);
    }
}
