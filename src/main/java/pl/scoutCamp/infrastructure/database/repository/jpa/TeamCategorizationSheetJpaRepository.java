package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.TeamCategorizationSheetEntity;

@Repository
public interface TeamCategorizationSheetJpaRepository extends JpaRepository<TeamCategorizationSheetEntity, Integer> {
}
