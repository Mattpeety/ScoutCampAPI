package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.Team;

import java.util.Optional;

public interface TeamDAO {

    Optional<Team> findTeamByName(String name);
}
