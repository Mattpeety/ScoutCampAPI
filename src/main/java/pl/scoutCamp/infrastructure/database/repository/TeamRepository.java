package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TeamDAO;
import pl.scoutCamp.domain.exception.Team;
import pl.scoutCamp.infrastructure.database.repository.jpa.TeamJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.TeamEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class TeamRepository implements TeamDAO {

    TeamJpaRepository teamJpaRepository;
    TeamEntityMapper teamEntityMapper;
    @Override
    public Optional<Team> findTeamByName(String name) {
        return teamJpaRepository.findTeamByName(name)
                .map(teamEntityMapper::mapFromEntity);
    }
}
