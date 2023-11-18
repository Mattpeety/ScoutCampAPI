package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.TeamCategorizationSheetAssignment;

import java.util.Optional;

public interface TeamCategorizationSheetAssignmentDAO {

    Optional<TeamCategorizationSheetAssignment> findTeamCategorizationSheetAssignmentById(Integer id);
}
