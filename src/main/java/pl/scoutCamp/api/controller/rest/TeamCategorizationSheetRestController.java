package pl.scoutCamp.api.controller.rest;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.scoutCamp.api.dto.*;
import pl.scoutCamp.api.dto.dtoList.TeamCategorizationSheetsDTO;
import pl.scoutCamp.api.dto.mapper.*;
import pl.scoutCamp.business.*;
import pl.scoutCamp.domain.TeamCategorizationSheet;
import pl.scoutCamp.domain.TeamCategorizationSheetAssignment;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(TeamCategorizationSheetRestController.API_TEAM_SHEETS)
public class TeamCategorizationSheetRestController {

    public static final String API_TEAM_SHEETS = "/team_categorization_sheet";
    public static final String TEAM_CATEGORIZATION_SHEETS_IN_PERIOD = "all_sheets_in_period/{period}";
    public static final String NEW_TEAM_SHEET = "/new";
    public static final String FILLED_ASSIGNMENTS = "/filled_assignments";
    public static final String TEAM_SHEET_RESULT = "/%s";

    private TeamService teamService;
    private CategoryService categoryService;
    private CategorizationSheetService categorizationSheetService;
    private TeamCategorizationSheetService teamCategorizationSheetService;
    private TeamCategorizationSheetAssignmentService teamCategorizationSheetAssignmentService;
    private TeamCategorizationSheetAssignmentMapper teamCategorizationSheetAssignmentMapper;
    private TeamCategorizationSheetMapper teamCategorizationSheetMapper;
    private CategorizationSheetMapper categorizationSheetMapper;
    private CategoryMapper categoryMapper;
    private TeamMapper teamMapper;

    @GetMapping(value = TEAM_CATEGORIZATION_SHEETS_IN_PERIOD)
    @JsonView(JsonViews.RankingView.class)
    public TeamCategorizationSheetsDTO getTeamCategorizationSheetsByPeriod(
            @PathVariable String period,
            @RequestParam int teamId
    ) {
        return getTeamCategorizationSheetsDTO(period, teamId);
    }

    private TeamCategorizationSheetsDTO getTeamCategorizationSheetsDTO(String period, int teamId) {
        return TeamCategorizationSheetsDTO.builder()
                .teamCategorizationSheets(getAllTeamCategorizationSheetsDTO(period, teamId))
                .build();
    }

    private List<TeamCategorizationSheetDTO> getAllTeamCategorizationSheetsDTO(String period, int teamId) {
        return teamCategorizationSheetService.getTeamSheets(teamId, period).stream()
                .map(teamCategorizationSheetMapper::map)
                .toList();
    }

    @PostMapping(value = NEW_TEAM_SHEET)
    public ResponseEntity<TeamCategorizationSheetDTO> addTeamCategorizationSheet(
            @RequestParam int teamId,
            @RequestParam int points,
            @RequestParam int categoryId,
            @RequestParam int categorizationSheetId,
            @RequestParam(defaultValue = "true") boolean isDraft
    ) {

        TeamCategorizationSheet mappedTeamCategorizationSheet = mappedTeamCategorizationSheet(teamId, points, categoryId, categorizationSheetId, isDraft);
        TeamCategorizationSheet newTeamCategorizationSheet = teamCategorizationSheetService.createNewTeamCategorizationSheet(mappedTeamCategorizationSheet);
        return ResponseEntity.created(URI.create(API_TEAM_SHEETS + TEAM_SHEET_RESULT.formatted(newTeamCategorizationSheet.getId()))).build();
    }

    @PostMapping(value = FILLED_ASSIGNMENTS)
    public ResponseEntity<List<TeamCategorizationSheetAssignmentDTO>> addFilledTeamCategorizationSheetAssignments(
            @RequestBody List<TeamCategorizationSheetAssignmentDTO> teamCategorizationSheetAssignmentsDTO
    ) {
        List<TeamCategorizationSheetAssignment> filledAssignmentsList =
                teamCategorizationSheetAssignmentService.createFilledAssignmentsList(mappedFilledAssignmentsList(teamCategorizationSheetAssignmentsDTO));
        return ResponseEntity.created(URI.create(API_TEAM_SHEETS + TEAM_SHEET_RESULT
                .formatted(filledAssignmentsList.get(0).getTeamCategorizationSheet().getId()))).build();
    }

    private List<TeamCategorizationSheetAssignment> mappedFilledAssignmentsList(List<TeamCategorizationSheetAssignmentDTO> teamCategorizationSheetAssignmentsDTO) {
        return teamCategorizationSheetAssignmentsDTO.stream().map(teamCategorizationSheetAssignmentMapper::map).toList();
    }

    private TeamCategorizationSheet mappedTeamCategorizationSheet(int teamId, int points, int categoryId, int categorizationSheetId, boolean isDraft) {
        return teamCategorizationSheetMapper.map(getTeamCategorizationSheetDTO(teamId, points, categoryId, categorizationSheetId, isDraft));
    }

    private TeamCategorizationSheetDTO getTeamCategorizationSheetDTO(int teamId, int points, int categoryId, int categorizationSheetId, boolean isDraft) {
        return TeamCategorizationSheetDTO.builder()
                .team(getTeamById(teamId))
                .points(points)
                .category(getCategoryById(categoryId))
                .categorizationSheet(getCategorizationSheetId(categorizationSheetId))
                .isDraft(isDraft)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    private CategorizationSheetDTO getCategorizationSheetId(int categorizationSheetId) {
        return categorizationSheetMapper.map(categorizationSheetService.findCategorizationSheetById(categorizationSheetId));
    }

    private TeamDTO getTeamById(int teamId) {
        return teamMapper.map(teamService.findTeamById(teamId));
    }

    private CategoryDTO getCategoryById(int categoryId) {
        return categoryMapper.map(categoryService.findCategoryById(categoryId));
    }

}
