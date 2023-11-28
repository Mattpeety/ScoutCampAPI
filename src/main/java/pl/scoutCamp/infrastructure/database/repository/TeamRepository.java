package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TeamDAO;
import pl.scoutCamp.domain.Regiment;
import pl.scoutCamp.domain.Team;
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;
import pl.scoutCamp.infrastructure.database.repository.jpa.TeamJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.RegimentEntityMapper;
import pl.scoutCamp.infrastructure.database.repository.mapper.TeamEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class TeamRepository implements TeamDAO {

    private final TeamJpaRepository teamJpaRepository;
    private final TeamEntityMapper teamEntityMapper;

    @Override
    public Optional<Team> findTeamByName(String name) {
        return teamJpaRepository.findTeamByName(name)
                .map(teamEntityMapper::mapFromEntity);
    }

    @Override
    public List<Team> findTeams() {
        return teamJpaRepository.findAll()
                .stream().map(teamEntityMapper::mapFromEntity)
                .toList();
    }


    @Override
    public List<Team> findTeamsByRegimentId(Integer regimentId) {
        return findTeams().stream()
                .filter(team -> team.getRegiment().getId().equals(regimentId))
                .toList();
    }

    @Override
    public List<Team> findTeamsByTroopId(Integer troopId) {
        return findTeams().stream()
                .filter(team -> team.getTroop().getId().equals(troopId))
                .toList();
    }

    @Override
    public List<Team> findTeamsByUserId(Integer userId) {
        return findTeams().stream()
                .filter(user -> user.getUser().getId().equals(userId))
                .toList();
    }


}
