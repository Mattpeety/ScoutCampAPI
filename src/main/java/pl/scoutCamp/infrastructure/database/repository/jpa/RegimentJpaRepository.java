package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegimentJpaRepository extends JpaRepository<RegimentEntity, Integer>{
    
    Optional<RegimentEntity> findRegimentByName(String name);

}
