package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.CategorizationSheetDAO;
import pl.scoutCamp.domain.CategorizationSheet;
import pl.scoutCamp.infrastructure.database.repository.jpa.CategorizationSheetJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.CategorizationSheetEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class CategorizationSheetRepository implements CategorizationSheetDAO {

    CategorizationSheetJpaRepository categorizationSheetJpaRepository;
    CategorizationSheetEntityMapper categorizationSheetEntityMapper;

    @Override
    public Optional<CategorizationSheet> findCategorizationSheetById(Integer id) {
        return categorizationSheetJpaRepository.findCategorizationSheetById(id)
                .map(categorizationSheetEntityMapper::mapFromEntity);
    }
}
