package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.RegimentDAO;
import pl.scoutCamp.domain.Regiment;
import pl.scoutCamp.infrastructure.database.repository.jpa.RegimentJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.RegimentEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class RegimentRepository implements RegimentDAO {

    RegimentJpaRepository regimentJpaRepository;
     RegimentEntityMapper regimentEntityMapper;

    @Override
    public Optional<Regiment> findRegimentByName(String name) {
        return regimentJpaRepository.findRegimentByName(name)
                .map(regimentEntityMapper::mapFromEntity);
    }

    @Override
    public List<Regiment> findAvailable() {
        return regimentJpaRepository.findAll().stream()
                .map(regimentEntityMapper::mapFromEntity)
                .toList();
    }


}
