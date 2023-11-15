package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.TeamEntity;

@Repository
public interface TeamJpaRepository extends JpaRepository<TeamEntity, Integer>{
}
