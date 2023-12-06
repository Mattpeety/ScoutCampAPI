package pl.scoutCamp.infrastructure.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.UserEntity;

@Repository
public interface AppUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);
}
