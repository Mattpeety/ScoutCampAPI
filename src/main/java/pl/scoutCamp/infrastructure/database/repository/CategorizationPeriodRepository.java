package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.CategorizationPeriodDAO;
import pl.scoutCamp.domain.CategorizationPeriod;
import pl.scoutCamp.infrastructure.database.repository.jpa.CategorizationPeriodJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.CategorizationPeriodEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CategorizationPeriodRepository implements CategorizationPeriodDAO {

    CategorizationPeriodJpaRepository categorizationPeriodJpaRepository;
    CategorizationPeriodEntityMapper categorizationPeriodEntityMapper;
    @Override
    public Optional<CategorizationPeriod> findCategorizationPeriodByName(String name) {
        return categorizationPeriodJpaRepository.findCategorizationPeriodByName(name)
                .map(categorizationPeriodEntityMapper::mapFromEntity);
    }
}
