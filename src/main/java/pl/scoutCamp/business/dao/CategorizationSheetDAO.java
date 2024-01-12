package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.CategorizationSheet;

import java.util.List;
import java.util.Optional;

public interface CategorizationSheetDAO {

    Optional<CategorizationSheet> findCategorizationSheetById(Integer id);
}
