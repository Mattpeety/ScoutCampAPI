package pl.scoutCamp.api.controller.rest;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.scoutCamp.api.dto.*;
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

    public static final String API_TEAM_SHEETS = "/categorization_team_sheet";
    public static final String NEW_TEAM_SHEET = "/new";
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

    @PostMapping(value = NEW_TEAM_SHEET)
    public ResponseEntity<TeamCategorizationSheetDTO> addTeamSheetAssignments(
            @RequestParam int teamId,
            @RequestParam int points,
            @RequestParam int categoryId,
            @RequestParam int categorizationSheetId,
            @RequestParam(defaultValue = "true") boolean isDraft,
            @RequestBody List<TeamCategorizationSheetAssignmentDTO> teamCategorizationSheetAssignmentsDTO
    ) {

        TeamCategorizationSheet newTeamCategorizationSheet
                = teamCategorizationSheetService.createNewTeamCategorizationSheet(mappedTeamCategorizationSheet(teamId, points, categoryId, categorizationSheetId, isDraft));
        teamCategorizationSheetAssignmentService.createFilledAssignmentsList(mappedFilledAssignmentsList(teamCategorizationSheetAssignmentsDTO));
        return ResponseEntity.created(URI.create(API_TEAM_SHEETS + TEAM_SHEET_RESULT.formatted(newTeamCategorizationSheet.getId()))).build();
    }

    private List<TeamCategorizationSheetAssignment> mappedFilledAssignmentsList (List<TeamCategorizationSheetAssignmentDTO> teamCategorizationSheetAssignmentsDTO) {
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
