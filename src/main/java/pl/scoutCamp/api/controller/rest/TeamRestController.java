package pl.scoutCamp.api.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.scoutCamp.api.dto.TeamDTO;
import pl.scoutCamp.api.dto.dtoList.TeamsDTO;
import pl.scoutCamp.api.dto.mapper.TeamMapper;
import pl.scoutCamp.business.TeamService;
import pl.scoutCamp.domain.Team;
import pl.scoutCamp.infrastructure.database.entity.TeamEntity;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping(TeamRestController.API_TEAM)
public class TeamRestController {

    public static final String API_TEAM = "/team";
    public static final String ALL_TEAMS = "/teams";
    public static final String TEAMS_IN_REGIMENT = "/regiment{regimentId}/teams";
    public static final String TEAMS_IN_TROOP = "/troop{troopId}/teams";
    public static final String TEAMS_OF_USER = "/user{userId}/teams";
    public static final String NEW_TEAM = "/newTeam";
    public static final String TEAM_RESULT = "/%s";

    private final TeamMapper teamMapper;
    private final TeamService teamService;


    @GetMapping(value = ALL_TEAMS)
    public TeamsDTO findAllTeams() {
        return getTeamsDTO();
    }


    @GetMapping(value = TEAMS_IN_REGIMENT)
    @JsonView(JsonViews.NoRegimentView.class)
    public ResponseEntity<TeamsDTO> findTeamsInRegiment(@PathVariable Integer regimentId) {
        if (Objects.isNull(regimentId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getRegimentTeamsDTO(regimentId));
    }

    @JsonView(JsonViews.NoTroopView.class)
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

    @PostMapping(value = NEW_TEAM)
    public ResponseEntity<TeamDTO> addTeam(@Valid @RequestBody TeamDTO teamDTO) {
        Team team = teamMapper.map(teamDTO);
        TeamEntity newTeam = teamService.createNewTeam(team);
        return ResponseEntity.created(URI.create(API_TEAM + TEAM_RESULT.formatted(newTeam.getId()))).build();
    }


    private TeamsDTO getTeamsDTO() {
        return TeamsDTO.builder()
                .teams(getAllTeamsDTO())
                .build();
    }

    private List<TeamDTO> getAllTeamsDTO() {
        return teamService.findAvailableTeams().stream()
                .map(teamMapper::map)
                .toList();
    }

    private TeamsDTO getRegimentTeamsDTO(Integer regimentId) {
        return TeamsDTO.builder()
                .teams(getRegimentAllTeamsDTO(regimentId))
                .build();
    }


    private List<TeamDTO> getRegimentAllTeamsDTO(Integer regimentId) {

        return teamService.findTeamsByRegimentId(regimentId)
                .stream()
                .map(teamMapper::map)
                .toList();
    }

    private TeamsDTO getTroopTeamsDTO(Integer troopId) {
        return TeamsDTO.builder()
                .teams(getTroopAllTeamsDTO(troopId))
                .build();
    }

    private List<TeamDTO> getTroopAllTeamsDTO(Integer troopId) {
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
