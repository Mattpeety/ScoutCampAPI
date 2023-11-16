package pl.scoutCamp.infrastructure.database.repository;

import pl.scoutCamp.business.dao.TeamCategorizationSheetAssignmentDAO;
import pl.scoutCamp.domain.exception.TeamCategorizationSheetAssignment;
import pl.scoutCamp.infrastructure.database.repository.jpa.TeamCategorizationSheetAssignmentJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.TeamCategorizationSheetAssignmentEntityMapper;

import java.util.Optional;

public class TeamCategorizationSheetAssignmentRepository implements TeamCategorizationSheetAssignmentDAO {

    TeamCategorizationSheetAssignmentJpaRepository teamCategorizationSheetAssignmentJpaRepository;
    TeamCategorizationSheetAssignmentEntityMapper teamCategorizationSheetAssignmentEntityMapper;

    @Override
    public Optional<TeamCategorizationSheetAssignment> findTeamCategorizationSheetAssignmentById(Integer id) {
        return teamCategorizationSheetAssignmentJpaRepository.findTeamCategorizationSheetAssignmentById(id)
                .map(teamCategorizationSheetAssignmentEntityMapper::mapFromEntity);
    }
}
