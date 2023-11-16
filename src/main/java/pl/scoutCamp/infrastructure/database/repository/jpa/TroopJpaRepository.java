package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.TroopEntity;
import pl.scoutCamp.infrastructure.database.entity.UserEntity;

import java.util.Optional;

@Repository
public interface TroopJpaRepository extends JpaRepository<TroopEntity, Integer> {

    Optional<TroopEntity> findTroopByName (String name);
}
