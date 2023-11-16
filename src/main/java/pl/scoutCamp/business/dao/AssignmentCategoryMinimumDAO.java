package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.exception.AssignmentCategoryMinimum;

import java.util.Optional;

public interface AssignmentCategoryMinimumDAO {

    Optional<AssignmentCategoryMinimum> findAssignmentCategoryMinimumById(Integer id);
}
