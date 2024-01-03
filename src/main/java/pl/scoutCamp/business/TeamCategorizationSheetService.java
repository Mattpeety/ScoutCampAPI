package pl.scoutCamp.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.domain.TeamCategorizationSheet;
import pl.scoutCamp.domain.exception.NotFoundException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TeamCategorizationSheetService {

    private final TeamCategorizationSheetDAO teamCategorizationSheetDAO;


    public List<TeamCategorizationSheet> findTeamsSheetsByPeriod(String periodName) {
        List<TeamCategorizationSheet> allTeamsSheets = teamCategorizationSheetDAO.findTeamsSheetsByPeriod(periodName);
        if (allTeamsSheets.isEmpty()) {
            throw new NotFoundException("Could not find list of all teams' scores");
        }
        log.info("Number of teams' scores: [{}] in period [{}]", allTeamsSheets.size(), periodName);
        return allTeamsSheets;
    }
}
