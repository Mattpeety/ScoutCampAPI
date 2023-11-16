package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.exception.CategorizationPeriod;

import java.util.Optional;

public interface CategorizationPeriodDAO {

    Optional<CategorizationPeriod> findCategorizationPeriodByName(String name);
}
