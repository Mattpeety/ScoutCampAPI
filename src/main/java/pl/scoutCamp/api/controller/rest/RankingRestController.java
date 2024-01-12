package pl.scoutCamp.api.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.scoutCamp.api.dto.TeamCategorizationSheetDTO;
import pl.scoutCamp.api.dto.dtoList.TeamCategorizationSheetsDTO;
import pl.scoutCamp.api.dto.mapper.TeamCategorizationSheetMapper;
import pl.scoutCamp.business.TeamCategorizationSheetService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(RankingRestController.API_RANKING)

public class RankingRestController {

    public static final String API_RANKING = "/ranking";
    public static final String ALL_TEAMS = "/allTeams/{periodName}/sort_by={sortedBy}.{order}";
    public static final String BY_REGIMENT = "/regiment={regimentId}/{periodName}/sort_by={sortedBy}.{order}";

    private final TeamCategorizationSheetMapper teamCategorizationSheetMapper;
    private final TeamCategorizationSheetService teamCategorizationSheetService;

    @GetMapping(value = ALL_TEAMS)
    @JsonView(JsonViews.RankingView.class)
    public TeamCategorizationSheetsDTO findAllTeamsRanking
            (
                    @PathVariable String periodName,
                    @PathVariable String sortedBy,
                    @PathVariable String order
            ) {
        return getTeamCategorizationSheetsDTO(periodName, sortedBy, order);
    }

    @GetMapping(value = BY_REGIMENT)
    @JsonView(JsonViews.RankingView.class)
    public TeamCategorizationSheetsDTO findTeamsRankingByRegiment
            (
                    @PathVariable Integer regimentId,
                    @PathVariable String periodName,
                    @PathVariable String sortedBy,
                    @PathVariable String order
            ) {
        return getTeamCategorizationSheetsDTO(regimentId, periodName, sortedBy, order);
    }

    private TeamCategorizationSheetsDTO getTeamCategorizationSheetsDTO(String periodName, String sortedBy, String order) {
        return TeamCategorizationSheetsDTO.builder()
                .teamCategorizationSheets(getAllTeamCategorizationSheetsDTO(periodName, sortedBy, order))
                .build();
    }

    private TeamCategorizationSheetsDTO getTeamCategorizationSheetsDTO(Integer regimentId, String periodName, String sortedBy, String order) {
        return TeamCategorizationSheetsDTO.builder()
                .teamCategorizationSheets(getAllTeamCategorizationSheetsDTO(regimentId, periodName, sortedBy, order))
                .build();
    }

    private List<TeamCategorizationSheetDTO> getAllTeamCategorizationSheetsDTO(String periodName, String sortedBy, String order) {
        return teamCategorizationSheetService.getSortedRanking(periodName, sortedBy, order)
                .stream()
                .map(teamCategorizationSheetMapper::map)
                .toList();
    }

    private List<TeamCategorizationSheetDTO> getAllTeamCategorizationSheetsDTO(Integer regimentId, String periodName, String sortedBy, String order) {
        return teamCategorizationSheetService.getSortedRanking(regimentId, periodName, sortedBy, order)
                .stream()
                .map(teamCategorizationSheetMapper::map)
                .toList();
    }
}
