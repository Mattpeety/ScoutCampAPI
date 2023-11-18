package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.AssignmentGroupDAO;
import pl.scoutCamp.domain.AssignmentGroup;
import pl.scoutCamp.infrastructure.database.repository.jpa.AssignmentGroupJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.AssignmentGroupEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentGroupRepository implements AssignmentGroupDAO {

    AssignmentGroupJpaRepository assignmentGroupJpaRepository;
    AssignmentGroupEntityMapper assignmentGroupEntityMapper;

    @Override
    public Optional<AssignmentGroup> findAssignmentGroupByName(String name) {
        return assignmentGroupJpaRepository.findAssignmentGroupByName(name)
                .map(assignmentGroupEntityMapper::mapFromEntity);
    }
}
