package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.UserEntity;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
}
