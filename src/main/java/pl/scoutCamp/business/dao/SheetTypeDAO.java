package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.SheetType;

import java.util.List;
import java.util.Optional;

public interface SheetTypeDAO {

    Optional<SheetType> findSheetTypeByName(String name);

    List<SheetType> findSheetTypes();
}
