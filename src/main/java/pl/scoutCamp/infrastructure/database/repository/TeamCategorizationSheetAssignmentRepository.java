package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TeamCategorizationSheetAssignmentDAO;
import pl.scoutCamp.domain.TeamCategorizationSheetAssignment;
import pl.scoutCamp.infrastructure.database.repository.jpa.TeamCategorizationSheetAssignmentJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.TeamCategorizationSheetAssignmentEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class TeamCategorizationSheetAssignmentRepository implements TeamCategorizationSheetAssignmentDAO {

    TeamCategorizationSheetAssignmentJpaRepository teamCategorizationSheetAssignmentJpaRepository;
    TeamCategorizationSheetAssignmentEntityMapper teamCategorizationSheetAssignmentEntityMapper;

    @Override
    public Optional<TeamCategorizationSheetAssignment> findTeamCategorizationSheetAssignmentById(Integer id) {
        return teamCategorizationSheetAssignmentJpaRepository.findTeamCategorizationSheetAssignmentById(id)
                .map(teamCategorizationSheetAssignmentEntityMapper::mapFromEntity);
    }
}
