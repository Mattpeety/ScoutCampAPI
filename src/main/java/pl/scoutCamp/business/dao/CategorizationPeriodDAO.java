package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.CategorizationPeriod;

import java.util.List;
import java.util.Optional;

public interface CategorizationPeriodDAO {

    Optional<CategorizationPeriod> findCategorizationPeriodByName(String name);

    List<CategorizationPeriod> findAvailable();
}
