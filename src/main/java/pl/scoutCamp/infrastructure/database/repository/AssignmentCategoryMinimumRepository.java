package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.AssignmentCategoryMinimumDAO;
import pl.scoutCamp.domain.exception.AssignmentCategoryMinimum;
import pl.scoutCamp.infrastructure.database.repository.jpa.AssignmentCategoryMinimumJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.AssignmentCategoryMinimumEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AssignmentCategoryMinimumRepository  implements AssignmentCategoryMinimumDAO {

    AssignmentCategoryMinimumJpaRepository assignmentCategoryMinimumJpaRepository;
    AssignmentCategoryMinimumEntityMapper assignmentCategoryMinimumEntityMapper;


    @Override
    public Optional<AssignmentCategoryMinimum> findAssignmentCategoryMinimumById(Integer id) {
        return assignmentCategoryMinimumJpaRepository.findAssignmentCategoryMinimumById(id)
                .map(assignmentCategoryMinimumEntityMapper::mapFromEntity);
    }
}
