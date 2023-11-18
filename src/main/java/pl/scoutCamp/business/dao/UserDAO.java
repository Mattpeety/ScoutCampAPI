package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    Optional<User> findUserByFirstName(String firstName);
    Optional<User> findUserByLastName(String lastName);

    List<User> findAvailable();
}
