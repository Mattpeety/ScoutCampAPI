package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.exception.Troop;

import java.util.Optional;

public interface TroopDAO {

    Optional<Troop> findTroopByName(String name);
}
