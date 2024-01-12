package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.RoleEntity;

@Repository
public interface RoleJpaRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);
}
