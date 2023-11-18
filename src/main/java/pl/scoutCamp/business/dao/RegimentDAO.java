package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.Regiment;

import java.util.List;
import java.util.Optional;

public interface RegimentDAO {

    Optional<Regiment> findRegimentByName(String name);

    List<Regiment> findAvailable();
}
