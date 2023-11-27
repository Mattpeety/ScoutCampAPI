package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.Regiment;
import pl.scoutCamp.domain.Team;

import java.util.List;
import java.util.Optional;

public interface TeamDAO {

    Optional<Team> findTeamByName(String name);
    List<Team> findTeams();

    List<Team> findTeamByRegimentId (Integer regimentId);
    List<Team> findTeamByTroopId (Integer troopId);
    List<Team> findTeamByUserId (Integer userId);
}
