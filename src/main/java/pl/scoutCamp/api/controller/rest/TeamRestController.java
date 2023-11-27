package pl.scoutCamp.api.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.scoutCamp.api.dto.TeamDTO;
import pl.scoutCamp.api.dto.TeamsDTO;
import pl.scoutCamp.api.dto.mapper.TeamMapper;
import pl.scoutCamp.business.TeamService;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping(TeamRestController.API_TEAM)
public class TeamRestController {

    private final TeamMapper teamMapper;
    private final TeamService teamService;

    public static final String API_TEAM = "/team";
    public static final String TEAMS_IN_REGIMENT = "/{regimentId}/teams";

    @GetMapping(value = TEAMS_IN_REGIMENT)
    public ResponseEntity<TeamsDTO> findTeamsInRegiment(@PathVariable Integer regimentId) {
        if (Objects.isNull(regimentId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getTeamsDTO(regimentId));
    }

    private TeamsDTO getTeamsDTO(Integer regimentId) {
        return TeamsDTO.builder()
                .teams(getTeamsDTOInRegiment(regimentId))
                .build();
    }

    private List<TeamDTO> getTeamsDTOInRegiment(Integer regimentId) {
        return teamService.findTeamsByRegimentId(regimentId).stream()
                .map(teamMapper::map)
                .toList();
    }
}
