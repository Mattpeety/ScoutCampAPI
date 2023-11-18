package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.CategorizationPeriodEntity;

import java.util.Optional;

@Repository
public interface CategorizationPeriodJpaRepository extends JpaRepository<CategorizationPeriodEntity, Integer> {

    Optional<CategorizationPeriodEntity> findCategorizationPeriodByName(String name);
}
