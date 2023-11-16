package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.RegimentDAO;
import pl.scoutCamp.domain.exception.Regiment;
import pl.scoutCamp.infrastructure.database.repository.jpa.RegimentJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.RegimentEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class RegimentRepository implements RegimentDAO {

    RegimentJpaRepository regimentJpaRepository;
    RegimentEntityMapper regimentEntityMapper;

    @Override
    public Optional<Regiment> findRegimentByName(String name) {
        return regimentJpaRepository.findRegimentByName(name)
                .map(regimentEntityMapper::mapFromEntity);
    }
}
