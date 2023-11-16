package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.exception.SheetType;

import java.util.Optional;

public interface SheetTypeDAO {

    Optional<SheetType> findSheetTypeByName(String name);
}
