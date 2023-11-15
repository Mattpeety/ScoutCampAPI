package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.TeamCategorizationSheetAssignmentEntity;

@Repository
public interface TeamCategorizationSheetAssignmentJpaRepository
        extends JpaRepository<TeamCategorizationSheetAssignmentEntity, Integer>{
}
