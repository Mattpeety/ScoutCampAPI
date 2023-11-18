package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.AssignmentDAO;
import pl.scoutCamp.domain.Assignment;
import pl.scoutCamp.infrastructure.database.repository.jpa.AssignmentJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.AssignmentEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentRepository implements AssignmentDAO {

    AssignmentJpaRepository assignmentJpaRepository;
    AssignmentEntityMapper assignmentEntityMapper;

    @Override
    public Optional<Assignment> findAssignmentById(Integer id) {
        return assignmentJpaRepository.findAssignmentById(id)
                .map(assignmentEntityMapper::mapFromEntity);
    }
}
