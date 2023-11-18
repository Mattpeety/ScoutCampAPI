package pl.scoutCamp.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.RegimentDAO;
import pl.scoutCamp.domain.Regiment;
import pl.scoutCamp.domain.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class RegimentService {

    private final RegimentDAO regimentDAO;

    @Transactional
    public List<Regiment> findAvailableRegiments() {
        List<Regiment> availableRegiments = regimentDAO.findAvailable();
        log.info("Available regiments: [{}]", availableRegiments.size());
        return availableRegiments;
    }

    @Transactional
    public Regiment findRegiment(String name) {
        Optional<Regiment> regiment = regimentDAO.findRegimentByName(name);
        if (regiment.isEmpty()) {
            throw new NotFoundException("Could not find regiment by name: [%s]".formatted(name));
        }
        return regiment.get();
    }
}
