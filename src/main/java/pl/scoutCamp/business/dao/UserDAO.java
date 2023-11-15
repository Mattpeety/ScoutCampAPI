package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.exception.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    Optional<User> findUserByFirstName(String id);
    Optional<User> findUserByLastName(String id);

    List<User> findAvailable();
}
