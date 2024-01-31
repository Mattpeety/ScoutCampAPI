package pl.scoutCamp.api.controller.rest;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.scoutCamp.api.dto.TeamCategorizationSheetAssignmentDTO;
import pl.scoutCamp.api.dto.dtoList.TeamCategorizationSheetAssignmentsDTO;
import pl.scoutCamp.api.dto.mapper.TeamCategorizationSheetAssignmentMapper;
import pl.scoutCamp.business.TeamCategorizationSheetAssignmentService;
import pl.scoutCamp.domain.TeamCategorizationSheetAssignment;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(TeamCategorizationSheetAssignmentsRestController.API_TEAM_SHEETS)
public class TeamCategorizationSheetAssignmentsRestController {

    public static final String API_TEAM_SHEETS = "/team_sheets";
    public static final String NEW_TEAM_SHEET = "/new";
    public static final String TEAM_SHEET_RESULT = "/%s";

    private final TeamCategorizationSheetAssignmentService teamCategorizationSheetAssignmentService;
    private final TeamCategorizationSheetAssignmentMapper teamCategorizationSheetAssignmentMapper;

    @PostMapping(value = NEW_TEAM_SHEET)
    public ResponseEntity<TeamCategorizationSheetAssignmentsDTO> addTeamSheetAssignments(
            @RequestBody List<TeamCategorizationSheetAssignmentDTO> teamCategorizationSheetAssignments) {
        List<TeamCategorizationSheetAssignment> newSheet = getTeamCategorizationSheetAssignments(teamCategorizationSheetAssignments);
        return ResponseEntity.created(URI.create(API_TEAM_SHEETS + TEAM_SHEET_RESULT.formatted(newSheet))).build();
    }

    private List<TeamCategorizationSheetAssignment> getTeamCategorizationSheetAssignments(
            List<TeamCategorizationSheetAssignmentDTO> teamCategorizationSheetAssignments) {
        return teamCategorizationSheetAssignmentService.createNewTeamSheetAssignments(
                teamCategorizationSheetAssignments.stream().map(teamCategorizationSheetAssignmentMapper::map)
                        .toList());
    }
}
