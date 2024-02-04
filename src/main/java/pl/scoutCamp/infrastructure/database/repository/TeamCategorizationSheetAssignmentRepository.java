package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TeamCategorizationSheetAssignmentDAO;
import pl.scoutCamp.domain.TeamCategorizationSheetAssignment;
import pl.scoutCamp.infrastructure.database.repository.jpa.TeamCategorizationSheetAssignmentJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.TeamCategorizationSheetAssignmentEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TeamCategorizationSheetAssignmentRepository implements TeamCategorizationSheetAssignmentDAO {

    TeamCategorizationSheetAssignmentJpaRepository teamCategorizationSheetAssignmentJpaRepository;
    TeamCategorizationSheetAssignmentEntityMapper teamCategorizationSheetAssignmentEntityMapper;

    @Override
    public Optional<TeamCategorizationSheetAssignment> findTeamCategorizationSheetAssignmentById(Integer id) {
        return teamCategorizationSheetAssignmentJpaRepository.findTeamCategorizationSheetAssignmentById(id)
                .map(teamCategorizationSheetAssignmentEntityMapper::mapFromEntity);
    }

    @Override
    public void createNewFilledAssignmentsList(List<TeamCategorizationSheetAssignment> teamCategorizationSheetAssignments) {
       var newFilledAssignmentsList = teamCategorizationSheetAssignments.stream()
                .map(teamCategorizationSheetAssignmentEntityMapper::mapToEntity)
                .toList();
       teamCategorizationSheetAssignmentJpaRepository.saveAllAndFlush(newFilledAssignmentsList);
    }
}
