package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.AssignmentGroupEntity;

import java.util.Optional;

@Repository
public interface AssignmentGroupJpaRepository extends JpaRepository<AssignmentGroupEntity, Integer>{

    Optional<AssignmentGroupEntity> findAssignmentGroupByName(String name);
}
