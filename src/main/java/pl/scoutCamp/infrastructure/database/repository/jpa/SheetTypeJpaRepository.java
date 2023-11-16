package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.SheetTypeEntity;

import java.util.Optional;

@Repository
public interface SheetTypeJpaRepository extends JpaRepository<SheetTypeEntity, Integer> {

    Optional<SheetTypeEntity> findSheetTypeByName(String name);
}
