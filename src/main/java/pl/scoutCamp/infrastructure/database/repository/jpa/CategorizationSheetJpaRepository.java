package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.CategorizationSheetEntity;

import java.util.Optional;

@Repository
public interface CategorizationSheetJpaRepository extends JpaRepository<CategorizationSheetEntity, Integer>{

    Optional<CategorizationSheetEntity> findCategorizationSheetById(Integer id);
}
