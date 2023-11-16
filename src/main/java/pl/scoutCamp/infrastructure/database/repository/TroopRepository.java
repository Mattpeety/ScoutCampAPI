package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TroopDAO;
import pl.scoutCamp.domain.exception.Troop;
import pl.scoutCamp.infrastructure.database.repository.jpa.TroopJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.TroopEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class TroopRepository implements TroopDAO {

    TroopJpaRepository troopJpaRepository;
    TroopEntityMapper troopEntityMapper;
    @Override
    public Optional<Troop> findTroopByName(String name) {
        return troopJpaRepository.findTroopByName(name)
                .map(troopEntityMapper::mapFromEntity);
    }
}
