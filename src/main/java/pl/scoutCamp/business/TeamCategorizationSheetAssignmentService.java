package pl.scoutCamp.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.TeamCategorizationSheetAssignmentDAO;
import pl.scoutCamp.domain.TeamCategorizationSheetAssignment;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TeamCategorizationSheetAssignmentService {

    TeamCategorizationSheetAssignmentDAO teamCategorizationSheetAssignmentDAO;
    public void createFilledAssignmentsList(List<TeamCategorizationSheetAssignment> teamCategorizationSheetAssignments) {
        teamCategorizationSheetAssignmentDAO.createNewFilledAssignmentsList(teamCategorizationSheetAssignments);
    }
}
