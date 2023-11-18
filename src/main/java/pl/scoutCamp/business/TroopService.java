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

    TroopDAO troopDAO;
    RegimentService regimentService;

@Transactional
    public List<Troop> findByRegimentName(String regimentName) {
    List<Troop> troopsInRegiment = troopDAO.findByRegimentName(regimentName);
    if (troopsInRegiment.isEmpty()) {
        throw new NotFoundException("Could not find troops in regiment by name: [%s]".formatted(regimentName));
    }
    return troopsInRegiment;
}
}
