package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.domain.exception.Team;
import pl.scoutCamp.infrastructure.database.entity.TeamEntity;

import java.util.Optional;

@Repository
public interface TeamJpaRepository extends JpaRepository<TeamEntity, Integer>{

    Optional<TeamEntity> findTeamByName(String name);
}
