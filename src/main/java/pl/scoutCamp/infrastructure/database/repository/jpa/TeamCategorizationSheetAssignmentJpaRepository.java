package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.TeamCategorizationSheetAssignmentEntity;

import java.util.Optional;

@Repository
public interface TeamCategorizationSheetAssignmentJpaRepository
        extends JpaRepository<TeamCategorizationSheetAssignmentEntity, Integer>{

    Optional<TeamCategorizationSheetAssignmentEntity> findTeamCategorizationSheetAssignmentById(Integer id);
}
