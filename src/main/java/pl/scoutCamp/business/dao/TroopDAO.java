package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.Regiment;
import pl.scoutCamp.domain.Troop;
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;
import pl.scoutCamp.infrastructure.database.entity.TroopEntity;

import java.util.List;
import java.util.Optional;

public interface TroopDAO {



    Optional<Troop> findTroopByName(String name);

    List<Troop> findByRegimentId(Integer regimentId);


    TroopEntity saveNewTroop(Troop troop);
}
