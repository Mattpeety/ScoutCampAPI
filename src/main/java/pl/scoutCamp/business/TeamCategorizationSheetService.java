package pl.scoutCamp.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.domain.TeamCategorizationSheet;

@Slf4j
@Service
@AllArgsConstructor
public class TeamCategorizationSheetService {

    TeamCategorizationSheetDAO teamCategorizationSheetDAO;

    @Transactional
    public TeamCategorizationSheet createNewTeamCategorizationSheet(TeamCategorizationSheet teamCategorizationSheet) {
       return teamCategorizationSheetDAO.saveNewTeamCategorizationSheet(teamCategorizationSheet);
    }
}
