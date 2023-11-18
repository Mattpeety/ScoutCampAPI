package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.AssignmentCategoryMinimum;

import java.util.Optional;

public interface AssignmentCategoryMinimumDAO {

    Optional<AssignmentCategoryMinimum> findAssignmentCategoryMinimumById(Integer id);
}
