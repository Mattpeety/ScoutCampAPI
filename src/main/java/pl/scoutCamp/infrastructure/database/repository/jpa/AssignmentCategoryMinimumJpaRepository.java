package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.AssignmentCategoryMinimumEntity;

@Repository
public interface AssignmentCategoryMinimumJpaRepository
        extends JpaRepository<AssignmentCategoryMinimumEntity, Integer>{
}
