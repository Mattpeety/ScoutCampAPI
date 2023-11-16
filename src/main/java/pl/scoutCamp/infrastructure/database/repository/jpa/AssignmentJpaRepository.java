package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.domain.exception.Assignment;
import pl.scoutCamp.infrastructure.database.entity.AssignmentEntity;

import java.util.Optional;

@Repository
public interface AssignmentJpaRepository extends JpaRepository<AssignmentEntity, Integer>{

    Optional<AssignmentEntity> findAssignmentById(Integer id);
}
