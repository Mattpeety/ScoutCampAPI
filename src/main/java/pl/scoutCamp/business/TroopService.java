package pl.scoutCamp.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.TroopDAO;
import pl.scoutCamp.domain.Troop;
import pl.scoutCamp.domain.exception.NotFoundException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TroopService {

   private final TroopDAO troopDAO;

    @Transactional
    public List<Troop> findByRegiment(Integer regimentId) {
        List<Troop> troopsInRegiment = troopDAO.findByRegimentId(regimentId);
        if (troopsInRegiment.isEmpty()) {
            throw new NotFoundException("Could not find troops in regiment by id: [%s]".formatted(regimentId));
        }

        log.info("Troops: [{}] in Regiment with id: [{}]", troopsInRegiment, regimentId);

        return troopsInRegiment;
    }
}
