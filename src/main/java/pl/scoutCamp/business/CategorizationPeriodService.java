package pl.scoutCamp.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.CategorizationPeriodDAO;
import pl.scoutCamp.domain.CategorizationPeriod;
import pl.scoutCamp.domain.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CategorizationPeriodService {

    private CategorizationPeriodDAO categorizationPeriodDAO;

    @Transactional
    public List<CategorizationPeriod> findAvailablePeriods() {
        List<CategorizationPeriod> availablePeriods = categorizationPeriodDAO.findAvailable();
        log.info("Available categorization periods: [{}]", availablePeriods.size());
        return  availablePeriods;
    }

    @Transactional
    public CategorizationPeriod findPeriod(String periodName) {
        Optional<CategorizationPeriod> period = categorizationPeriodDAO.findCategorizationPeriodByName(periodName);
        if (period.isEmpty()) {
            throw new NotFoundException("Could not find period by name: [%s]".formatted(periodName));
        }
        return period.get();
    }
}
