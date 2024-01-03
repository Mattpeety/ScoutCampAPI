package pl.scoutCamp.api.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.scoutCamp.api.dto.TeamCategorizationSheetDTO;
import pl.scoutCamp.api.dto.dtoList.TeamCategorizationSheetsDTO;
import pl.scoutCamp.api.dto.mapper.TeamCategorizationSheetMapper;
import pl.scoutCamp.business.TeamCategorizationSheetService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(RankingRestController.API_RANKING)
public class RankingRestController {
    public static final String API_RANKING = "/ranking";
    public static final String ALL_TEAMS = "/allTeams/{periodName}/sortedBy_{sortedBy}";
    public static final String BY_REGIMENT = "/regiment_{regimentId}/{periodName}/sortedBy_{sortedBy}";
    public static final String POINTS = "points";
    public static final String NAME = "name";
    public static final String CATEGORY = "category";

    private final TeamCategorizationSheetMapper teamCategorizationSheetMapper;
    private final TeamCategorizationSheetService teamCategorizationSheetService;

    @GetMapping(value = ALL_TEAMS)
    public TeamCategorizationSheetsDTO findAllTeamsRanking
            (
                    @PathVariable String periodName,
                    @PathVariable String sortedBy
            ) {
        return getTeamCategorizationSheetsDTO(periodName, sortedBy);
    }

    @GetMapping(value = BY_REGIMENT)
    public TeamCategorizationSheetsDTO findTeamsRankingByRegiment
            (
                    @PathVariable Integer regimentId,
                    @PathVariable String periodName,
                    @PathVariable String sortedBy
            ) {
       return getTeamCategorizationSheetsDTO(regimentId, periodName, sortedBy);
    }

    private TeamCategorizationSheetsDTO getTeamCategorizationSheetsDTO(String periodName, String sortedBy) {
        return TeamCategorizationSheetsDTO.builder()
                .teamCategorizationSheets(getAllTeamCategorizationSheetsDTO(periodName, sortedBy))
                .build();
    }

    private TeamCategorizationSheetsDTO getTeamCategorizationSheetsDTO(Integer regimentId, String periodName, String sortedBy) {
        return TeamCategorizationSheetsDTO.builder()
                .teamCategorizationSheets(getAllTeamCategorizationSheetsDTO(regimentId, periodName, sortedBy))
                .build();
    }

    private List<TeamCategorizationSheetDTO> getAllTeamCategorizationSheetsDTO(String periodName, String sortedBy) {
        List<TeamCategorizationSheetDTO> teamsByPeriod = new ArrayList<>(teamCategorizationSheetService
                .findTeamsSheetsByPeriod(periodName)
                .stream()
                .map(teamCategorizationSheetMapper::map)
                .toList());
        return getSortedTeamCategorizationSheetsDTO(teamsByPeriod, sortedBy);
    }

    private List<TeamCategorizationSheetDTO> getAllTeamCategorizationSheetsDTO(Integer regimentId, String periodName, String sortedBy) {
        List<TeamCategorizationSheetDTO> teamsByPeriodAndRegiment = new ArrayList<>(teamCategorizationSheetService
                .findTeamsSheetsByRegimentAndPeriod(regimentId, periodName)
                .stream()
                .map(teamCategorizationSheetMapper::map)
                .toList());
        return getSortedTeamCategorizationSheetsDTO(teamsByPeriodAndRegiment, sortedBy);
    }

    private List<TeamCategorizationSheetDTO> getSortedTeamCategorizationSheetsDTO
            (
                    List<TeamCategorizationSheetDTO> allTeamsCategorizationSheetsDTO,
                    String sortedBy
            ) {
        switch (sortedBy) {
            case POINTS -> allTeamsCategorizationSheetsDTO.sort(Comparator.comparing(
                    TeamCategorizationSheetDTO::getPoints));
            case NAME -> allTeamsCategorizationSheetsDTO.sort(Comparator.comparing(
                    TeamCategorizationSheetDTO -> TeamCategorizationSheetDTO.getTeam().getName()));
            case CATEGORY -> allTeamsCategorizationSheetsDTO.sort(Comparator.comparing(
                    TeamCategorizationSheetDTO -> TeamCategorizationSheetDTO.getCategory().getName()));
        }
        return allTeamsCategorizationSheetsDTO;
    }
}
