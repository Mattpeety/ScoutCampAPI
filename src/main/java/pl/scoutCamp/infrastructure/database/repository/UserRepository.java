package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.UserDAO;
import pl.scoutCamp.domain.exception.User;
import pl.scoutCamp.infrastructure.database.repository.jpa.UserJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.UserEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepository implements UserDAO {

    UserJpaRepository userJpaRepository;
    UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> findUserByFirstName(String firstName) {
        return userJpaRepository.findUserByFirstName(firstName)
                .map(userEntityMapper::mapFromEntity);
    }

    @Override
    public Optional<User> findUserByLastName(String lastName) {
        return userJpaRepository.findUserByLastName(lastName)
                .map(userEntityMapper::mapFromEntity);
    }

    @Override
    public List<User> findAvailable() {
        return userJpaRepository.findAll().stream()
                .map(userEntityMapper::mapFromEntity)
                .toList();
    }
}
