package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TroopDAO;
import pl.scoutCamp.domain.Troop;
import pl.scoutCamp.infrastructure.database.entity.TroopEntity;
import pl.scoutCamp.infrastructure.database.repository.jpa.TroopJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.TroopEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TroopRepository implements TroopDAO{

    private final TroopJpaRepository troopJpaRepository;

    private final TroopEntityMapper troopEntityMapper;

    @Override
    public Optional<Troop> findTroopByName(String name) {
        return troopJpaRepository.findTroopByName(name)
                .map(troopEntityMapper::mapFromEntity);
    }

    @Override
    public List<Troop> findByRegimentId(Integer regimentId) {
        return troopJpaRepository
                .findAll().stream()
                .map(troopEntityMapper::mapFromEntity)
                .filter(troop -> troop.getRegiment().getId().equals(regimentId))
                .toList();
    }


}
