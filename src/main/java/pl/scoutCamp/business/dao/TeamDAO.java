package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.Regiment;
import pl.scoutCamp.domain.Team;

import java.util.List;
import java.util.Optional;

public interface TeamDAO {

    Optional<Team> findTeamByName(String name);
    List<Team> findTeams();

    List<Team> findTeamsByRegimentId (Integer regimentId);
    List<Team> findTeamsByTroopId (Integer troopId);
    List<Team> findTeamsByUserId(Integer userId);
}
