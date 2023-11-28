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
    public static final String ALL_TEAMS = "/teams";
    public static final String TEAMS_IN_REGIMENT = "/regiment{regimentId}/teams";
    public static final String TEAMS_IN_TROOP = "/troop{troopId}/teams";
    public static final String TEAMS_OF_USER = "/user{userId}/teams";

    @GetMapping(value = ALL_TEAMS)
    public TeamsDTO findAllTeams() {
        return getTeamsDTO();
    }

    @GetMapping(value = TEAMS_IN_REGIMENT)
    public ResponseEntity<TeamsDTO> findTeamsInRegiment(@PathVariable Integer regimentId) {
        if (Objects.isNull(regimentId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getRegimentTeamsDTO(regimentId));
    }

    @GetMapping(value = TEAMS_IN_TROOP)
    public ResponseEntity<TeamsDTO> findTeamsInTroop(@PathVariable Integer troopId) {
        if (Objects.isNull(troopId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getTroopTeamsDTO(troopId));
    }

    @GetMapping(value = TEAMS_OF_USER)
    public ResponseEntity<TeamsDTO> findTeamsOfUser(@PathVariable Integer userId) {
        if (Objects.isNull(userId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getUserTeamsDTO(userId));
    }


    private TeamsDTO getTeamsDTO() {
        return TeamsDTO.builder()
                .teams(getAllTeamsDTO())
                .build();
    }

    private List<TeamDTO> getAllTeamsDTO() {
        return teamService.findAllTeams().stream()
                .map(teamMapper::map)
                .toList();
    }

    private TeamsDTO getRegimentTeamsDTO(Integer regimentId) {
        return TeamsDTO.builder()
                .teams(getRegimentAllTeamsDTO(regimentId))
                .build();
    }

    private List<TeamDTO> getRegimentAllTeamsDTO(Integer regimentId) {
        return teamService.findTeamsByRegimentId(regimentId).stream()
                .map(teamMapper::map)
                .toList();
    }

    private TeamsDTO getTroopTeamsDTO(Integer troopId) {
        return TeamsDTO.builder()
                .teams(getAllTroopTeamsDTO(troopId))
                .build();
    }

    private List<TeamDTO> getAllTroopTeamsDTO(Integer troopId) {
        return teamService.findTeamsByTroopId(troopId).stream()
                .map(teamMapper::map)
                .toList();
    }

    private TeamsDTO getUserTeamsDTO(Integer userId) {
        return TeamsDTO.builder()
                .teams(getAllUserTeamsDTO(userId))
                .build();
    }

    private List<TeamDTO> getAllUserTeamsDTO(Integer userId) {
        return teamService.findTeamsByUserId(userId).stream()
                .map(teamMapper::map)
                .toList();
    }
}
