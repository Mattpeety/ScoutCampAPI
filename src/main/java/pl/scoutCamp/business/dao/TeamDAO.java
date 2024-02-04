package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.Team;
import pl.scoutCamp.infrastructure.database.entity.TeamEntity;

import java.util.List;
import java.util.Optional;

public interface TeamDAO {

    Optional<Team> findTeamById(int id);
    List<Team> findTeams();

    List<Team> findTeamsByRegimentId (Integer regimentId);
    List<Team> findTeamsByTroopId (Integer troopId);
    List<Team> findTeamsByUserId(Integer userId);

    TeamEntity saveNewTeam(Team team);
}
