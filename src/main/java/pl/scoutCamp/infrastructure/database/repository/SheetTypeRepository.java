package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.SheetTypeDAO;
import pl.scoutCamp.domain.SheetType;
import pl.scoutCamp.infrastructure.database.repository.jpa.SheetTypeJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.SheetTypeEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class SheetTypeRepository implements SheetTypeDAO {

    SheetTypeJpaRepository sheetTypeJpaRepository;
    SheetTypeEntityMapper sheetTypeEntityMapper;


    @Override
    public Optional<SheetType> findSheetTypeByName(String name) {
        return sheetTypeJpaRepository.findSheetTypeByName(name)
                .map(sheetTypeEntityMapper::mapFromEntity);
    }
}
