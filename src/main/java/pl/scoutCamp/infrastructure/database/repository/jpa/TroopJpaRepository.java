package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;
import pl.scoutCamp.infrastructure.database.entity.TroopEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface TroopJpaRepository extends JpaRepository<TroopEntity, Integer> {

    Optional<TroopEntity> findTroopByName (String name);

    List<TroopEntity> findByRegimentName(String regimentName);
}
