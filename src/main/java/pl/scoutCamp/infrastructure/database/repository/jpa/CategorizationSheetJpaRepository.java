package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.CategorizationSheetEntity;

@Repository
public interface CategorizationSheetJpaRepository extends JpaRepository<CategorizationSheetEntity, Integer>{
}
