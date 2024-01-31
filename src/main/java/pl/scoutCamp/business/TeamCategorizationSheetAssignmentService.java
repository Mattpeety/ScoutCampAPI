package pl.scoutCamp.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.api.dto.mapper.TeamCategorizationSheetAssignmentMapper;
import pl.scoutCamp.business.dao.TeamCategorizationSheetAssignmentDAO;
import pl.scoutCamp.domain.TeamCategorizationSheetAssignment;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TeamCategorizationSheetAssignmentService {

    TeamCategorizationSheetAssignmentMapper teamCategorizationSheetAssignmentMapper;
    TeamCategorizationSheetAssignmentDAO teamCategorizationSheetAssignmentDAO;

    @Transactional
    public List<TeamCategorizationSheetAssignment> createNewTeamSheetAssignments(List<TeamCategorizationSheetAssignment> teamCategorizationSheetAssignments) {
        return teamCategorizationSheetAssignmentDAO.saveNewSheetAssignments(teamCategorizationSheetAssignments);
    }
}
