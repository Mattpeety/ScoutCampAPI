package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.exception.Regiment;

import java.util.Optional;

public interface RegimentDAO {

    Optional<Regiment> findRegimentByName(String name);
}
