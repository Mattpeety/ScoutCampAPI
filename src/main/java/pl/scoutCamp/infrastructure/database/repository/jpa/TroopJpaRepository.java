package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.TroopEntity;
import pl.scoutCamp.infrastructure.database.entity.UserEntity;

@Repository
public interface TroopJpaRepository extends JpaRepository<TroopEntity, Integer> {
}
