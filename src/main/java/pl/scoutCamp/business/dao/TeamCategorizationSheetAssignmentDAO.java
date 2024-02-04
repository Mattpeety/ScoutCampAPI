package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.TeamCategorizationSheetAssignment;
import pl.scoutCamp.infrastructure.database.entity.TeamCategorizationSheetAssignmentEntity;

import java.util.List;
import java.util.Optional;

public interface TeamCategorizationSheetAssignmentDAO {

    Optional<TeamCategorizationSheetAssignment> findTeamCategorizationSheetAssignmentById(Integer id);

    void createNewFilledAssignmentsList(List<TeamCategorizationSheetAssignment> teamCategorizationSheetAssignments);
}
